package adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.countdowncounter.R
import data.CountDown
import kotlinx.android.synthetic.main.recyclerview_item.view.*

class CountdownListAdapter(val context: Context,
                           var mList: List<CountDown>): RecyclerView.Adapter<CountdownListAdapter.CounterHolder>(){

    val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CounterHolder {
        val view = inflater.inflate(R.layout.recyclerview_item,parent,false)
        return  CounterHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: CounterHolder, position: Int) {
        val item = mList.get(position)
        holder.bind(item)
    }

    inner class CounterHolder(itemView:View ): RecyclerView.ViewHolder(itemView) {
        lateinit var countDownItem: CountDown
        val edit_counter = itemView.edit_countdown
        val title = itemView.reminder_itemlist_title
        val dateAndtime = itemView.reminder_itemlist_day_and_time
        val listner = itemView.setOnClickListener {
            Toast.makeText(context,"Clicked item: " + countDownItem.title, Toast.LENGTH_SHORT).show()
        }

        fun bind(countDown: CountDown) {
            countDownItem = countDown
            title.text = countDown.title
            dateAndtime.text = countDown.getFormatedDate()
            edit_counter.setOnClickListener {
                Toast.makeText(context,"You clicked edit",Toast.LENGTH_SHORT).show()
            }
        }

    }
}


