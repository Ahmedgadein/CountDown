package fragments

import activities.CountDownActivity
import adapters.CountdownListAdapter
import android.app.Application
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countdowncounter.R
import data.CountDown
import data.CountDownViewModel
import kotlinx.android.synthetic.main.fragment_countdown_list.view.*

class CountDownListFragment:Fragment() {

    companion object{
        fun newInstance() = CountDownListFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel:CountDownViewModel = CountDownViewModel(context?.applicationContext as Application)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_countdown_list,container,false)

        val mRecyclerView = view.recycler_view
        mRecyclerView.layoutManager = LinearLayoutManager(context)
        mRecyclerView.adapter = CountdownListAdapter(context!!,populateList())

        val floatingActionButton = view.action_button
        floatingActionButton.setOnClickListener {
            startActivity(Intent(activity,CountDownActivity::class.java))
        }
        return view
    }

    fun populateList(): List<CountDown>{
        val countlist = arrayListOf<CountDown>()
        for(i in 0..100){
            val count = CountDown(title = i.toString())
            countlist.add(count)
        }

        return countlist
    }
}