package data

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(CountDown::class), version = 1, exportSchema = false)
abstract class CountDownDatabase: RoomDatabase() {
    abstract fun getDao():CountDownDao

    //Singleton to prevent creation ot multiple database instances
    companion object{

        private val INSTANCE: CountDownDatabase? = null

        fun getDataBaseInstance(application: Application): CountDownDatabase{
            val tempInst = INSTANCE
            if (tempInst != null){
                return tempInst
            }

            synchronized(this){
                val Instance = Room.databaseBuilder(
                    application.applicationContext,
                    CountDownDatabase::class.java,
                    "countdown_database"
                ).build()
                return Instance
            }
        }
    }


}