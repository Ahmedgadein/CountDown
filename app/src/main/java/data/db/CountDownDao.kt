package data.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import data.model.CountDown
import java.util.*

@Dao
interface CountDownDao{

    @Query("SELECT * FROM countdown_table")
    fun getAll():LiveData<List<CountDown>>

    @Query("SELECT * FROM countdown_table WHERE uuid = :uuiD")
    fun getCountdown(uuiD:String): LiveData<CountDown>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(countDown: CountDown)

    @Delete()
    fun delete(countDown: CountDown)

    @Update
    fun update(countDown: CountDown)

    @Query("DELETE FROM countdown_table")
     fun deleteAll()

}