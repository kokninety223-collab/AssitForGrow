package com.example.data

import android.content.Context
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Entity(tableName = "planted_crops")
data class PlantedCrop(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val cropId: String,
    val cropName: String,
    val plantedTimestamp: Long,
    val harvestDateMin: Long,
    val harvestDateMax: Long
)

@Dao
interface PlantedCropDao {
    @Query("SELECT * FROM planted_crops ORDER BY plantedTimestamp DESC")
    fun getAllPlantedCrops(): Flow<List<PlantedCrop>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlantedCrop(crop: PlantedCrop)

    @Delete
    suspend fun deletePlantedCrop(crop: PlantedCrop)
}

@Database(entities = [PlantedCrop::class], version = 1, exportSchema = false)
abstract class TrackerDatabase : RoomDatabase() {
    abstract fun plantedCropDao(): PlantedCropDao

    companion object {
        @Volatile
        private var Instance: TrackerDatabase? = null

        fun getDatabase(context: Context): TrackerDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    TrackerDatabase::class.java,
                    "tracker_database"
                )
                .build()
                .also { Instance = it }
            }
        }
    }
}
