package fragments

import activities.CountDownActivity
import adapters.CountdownListAdapter
import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countdowncounter.R
import data.model.CountDown
import data.CountDownViewModel
import kotlinx.android.synthetic.main.fragment_countdown_list.view.*

class CountDownListFragment:Fragment() {
    lateinit var viewModel: CountDownViewModel
    var mAdapter:CountdownListAdapter? = null

    companion object{
        fun newInstance() = CountDownListFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_countdown_list,container,false)

        val mAdapter = CountdownListAdapter(activity!!)

        val mRecyclerView = view.recycler_view
        mRecyclerView.layoutManager = LinearLayoutManager(context)
        mRecyclerView.adapter = mAdapter

        val application = requireNotNull(activity).application
        viewModel = CountDownViewModel(application)

        viewModel.allCountDown.observe(this, Observer {
            it?.let {
                mAdapter.setCounters(it)
            }
        })


        val floatingActionButton = view.action_button
        floatingActionButton.setOnClickListener {
            startActivity(Intent(activity,CountDownActivity::class.java))
        }
        return view
    }

    fun updateUI(){

    }


}