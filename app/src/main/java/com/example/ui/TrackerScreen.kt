package com.example.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrackerScreen(
    viewModel: CropViewModel,
    onBackClick: () -> Unit
) {
    val plantedCrops by viewModel.plantedCrops.collectAsState()
    
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("စိုက်ပျိုးမှတ်တမ်း") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        if (plantedCrops.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "မှတ်တမ်းတင်ထားသော အပင်မရှိသေးပါ။",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        } else {
            LazyColumn(
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                items(plantedCrops) { crop ->
                    PlantedCropCard(
                        crop = crop,
                        onDeleteClick = { viewModel.deletePlantedCrop(crop) }
                    )
                }
            }
        }
    }
}

@Composable
fun PlantedCropCard(
    crop: com.example.data.PlantedCrop,
    onDeleteClick: () -> Unit
) {
    val dateFormat = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
    val plantedDate = dateFormat.format(Date(crop.plantedTimestamp))
    val harvestDateMin = dateFormat.format(Date(crop.harvestDateMin))
    val harvestDateMax = dateFormat.format(Date(crop.harvestDateMax))
    
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = crop.cropName,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "စိုက်ပျိုးသည့်ရက်: $plantedDate",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "ခန့်မှန်းရိတ်သိမ်းရက်: $harvestDateMin မှ $harvestDateMax",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            IconButton(onClick = onDeleteClick) {
                Icon(
                    Icons.Default.Delete,
                    contentDescription = "ဖျက်မည်",
                    tint = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}
