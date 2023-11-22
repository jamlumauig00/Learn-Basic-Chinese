package learn.basic.chinese.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ChineseModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    // Define your DAOs here
    abstract fun basicChineseDao(): ChineseDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null


        fun getChineseDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "LearnBasicChinese")
                        .createFromAsset("LearnBasicChinese.db")
                        .build()
                }
            }
            return INSTANCE!!
        }

    }
}


