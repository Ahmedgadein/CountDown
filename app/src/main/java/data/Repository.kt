package data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import data.db.CountDownDao
import data.model.CountDown
import java.util.*

class Repository(val dao: CountDownDao) {

/*    fun populateList(): LiveData<MutableList<CountDown>>{
        val countlist = mutableListOf<CountDown>()
        for(i in 0..100){
            val count = CountDown(title = i.toString())
            countlist.add(count)
            countlist = LiveData<>(countlist)
        }

        return countlist
    }*/

    val allCountDowns = dao.getAll()

    // invoke on coroutine or other suspend function only
    suspend fun insert(countDown: CountDown){
        dao.insert(countDown)
    }

    // invoke on coroutine or other suspend function only
    suspend fun delete(countDown: CountDown){
        dao.delete(countDown)
    }

    // invoke on coroutine or other suspend function only
    suspend fun update(countDown: CountDown){
        dao.insert(countDown)
    }

    fun getCountDown(uuid: UUID):LiveData<CountDown> = dao.getCountdown(uuid.toString())
}