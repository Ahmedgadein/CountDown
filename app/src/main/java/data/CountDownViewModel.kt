package data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class CountDownViewModel(application: Application) : AndroidViewModel(application) {

    private val repository:Repository
     val allCountDown: LiveData<List<CountDown>>

    init {
        val dao:CountDownDao = CountDownDatabase.getDataBaseInstance(application).getDao()
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
}