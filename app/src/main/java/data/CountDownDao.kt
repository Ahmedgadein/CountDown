package data

import androidx.lifecycle.LiveData
import androidx.room.*
import java.util.*

@Dao
interface CountDownDao{

    @Query("SELECT * FROM countdown_table")
    fun getAll():LiveData<List<CountDown>>

    @Insert
    fun insert(countDown: CountDown)

    @Delete
    fun delete(countDown: CountDown)

    @Update
    fun update(countDown: CountDown)

}