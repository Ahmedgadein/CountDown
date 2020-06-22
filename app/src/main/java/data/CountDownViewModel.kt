package data

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import data.db.CountDownDao
import data.db.CountDownDatabase
import data.model.CountDown
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*


class CountDownViewModel(application: Application) : AndroidViewModel(application) {

    private val repository:Repository
     val allCountDown: LiveData<List<CountDown>>

    init {
        val dao: CountDownDao = CountDownDatabase.getDataBaseInstance(application,viewModelScope).getDao()
        Log.d("Database","DatabaseCreated")
        repository = Repository(dao)
        allCountDown = repository.allCountDowns
    }

    fun insert(countDown: CountDown) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(countDown)
    }

    fun update(countDown: CountDown) = viewModelScope.launch (Dispatchers.IO){
        repository.update(countDown)
    }

    fun delete(countDown: CountDown) = viewModelScope.launch(Dispatchers.IO){
        repository.delete(countDown)
    }

    fun getCountDown(uuid: UUID): LiveData<CountDown> = repository.getCountDown(uuid)
}