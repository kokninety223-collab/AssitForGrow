package com.example.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.data.Crop
import com.example.data.CropData
import com.example.data.PlantedCrop
import com.example.data.PlantedCropDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.Calendar

class CropViewModel(private val dao: PlantedCropDao) : ViewModel() {
    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    private val _selectedCategory = MutableStateFlow("အားလုံး")
    val selectedCategory: StateFlow<String> = _selectedCategory

    val filteredCrops: StateFlow<List<Crop>> = combine(
        _searchQuery,
        _selectedCategory
    ) { query, category ->
        var list = CropData.crops
        if (category != "အားလုံး") {
            list = list.filter { it.category == category }
        }
        if (query.isNotBlank()) {
            list = list.filter { it.name.contains(query, ignoreCase = true) }
        }
        list
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), CropData.crops)

    val plantedCrops: StateFlow<List<PlantedCrop>> = dao.getAllPlantedCrops()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    private val _dataSaverEnabled = MutableStateFlow(false)
    val dataSaverEnabled: StateFlow<Boolean> = _dataSaverEnabled

    fun toggleDataSaver() {
        _dataSaverEnabled.value = !_dataSaverEnabled.value
    }

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun updateCategory(category: String) {
        _selectedCategory.value = category
    }

    fun plantCrop(crop: Crop) {
        viewModelScope.launch {
            val now = Calendar.getInstance().timeInMillis
            val minTime = now + (crop.harvestDaysMin * 24L * 60 * 60 * 1000)
            val maxTime = now + (crop.harvestDaysMax * 24L * 60 * 60 * 1000)
            
            dao.insertPlantedCrop(
                PlantedCrop(
                    cropId = crop.id,
                    cropName = crop.name,
                    plantedTimestamp = now,
                    harvestDateMin = minTime,
                    harvestDateMax = maxTime
                )
            )
        }
    }
    
    fun deletePlantedCrop(crop: PlantedCrop) {
        viewModelScope.launch {
            dao.deletePlantedCrop(crop)
        }
    }
}

class CropViewModelFactory(private val dao: PlantedCropDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CropViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CropViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
