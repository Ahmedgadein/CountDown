package data

import android.content.Context
import androidx.lifecycle.LiveData
import java.security.AccessControlContext

class Repository(val dao: CountDownDao) {

    val allCountDowns: LiveData<List<CountDown>> = dao.getAll()

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
}