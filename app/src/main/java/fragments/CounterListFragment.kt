package fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.countdowncounter.R
import kotlinx.android.synthetic.main.fragment_countdown_list.view.*

class CounterListFragment private constructor():Fragment() {

    companion object{
        fun newInstance() = CounterListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_countdown_list,container,false)

        val mRecyclerView = view.recycler_view

        val floatingActionButton = view.action_button
        floatingActionButton.setOnClickListener {
        }
        return view
    }
}