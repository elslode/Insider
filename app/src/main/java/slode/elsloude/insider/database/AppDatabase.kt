package slode.elsloude.insider.database

import android.content.Context
import androidx.room.*
import slode.elsloude.insider.POJO.NewsInfo

@Database(
    entities = [NewsInfo::class],
    version = 3,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        private var db: AppDatabase? = null
        private const val DB_NAME = "main.db"
        private val LOCK = Any()

        fun getInstance(context: Context): AppDatabase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance =
                    Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME).fallbackToDestructiveMigration().build()
                db = instance
                return instance
            }
        }
    }

    abstract fun NewsInfoListDao(): NewsInfoListDao
}