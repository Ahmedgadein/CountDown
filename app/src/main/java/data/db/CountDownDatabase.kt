package data.db

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import data.model.CountDown
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = arrayOf(CountDown::class), version = 1, exportSchema = false)
abstract class CountDownDatabase: RoomDatabase() {
    abstract fun getDao(): CountDownDao

    private class CountdownDatabaseCallback(private val scope: CoroutineScope) : RoomDatabase.Callback(){
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let {
                scope.launch(Dispatchers.IO){
                    var dao = it.getDao()
                    dao.deleteAll()

                    val CountDown = CountDown()
                    CountDown.title = "This"
                    dao.insert(CountDown)

                    val CountDown2 = CountDown()
                    CountDown2.title = "is"
                    dao.insert(CountDown2)

                    val CountDown3 = CountDown()
                    CountDown3.title = "Actually"
                    dao.insert(CountDown3)

                    val CountDown4 = CountDown()
                    CountDown4.title = "Working"
                    dao.insert(CountDown4)

                }
            }
        }
    }
    //Singleton to prevent creation ot multiple database instances
    companion object{

        private var INSTANCE: CountDownDatabase? = null

        fun getDataBaseInstance(context: Context,
                                scope:CoroutineScope): CountDownDatabase {
            synchronized(this){
                var tempInst = INSTANCE

                if (tempInst == null){
                    tempInst = Room.databaseBuilder(
                        context.applicationContext,
                        CountDownDatabase::class.java,
                        "countdown_database")
                        .addCallback(CountdownDatabaseCallback(scope))
                        .build()
                    INSTANCE = tempInst
                }
                return tempInst
            }
        }
    }


}