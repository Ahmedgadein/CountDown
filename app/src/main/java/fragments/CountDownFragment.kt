package fragments

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.countdowncounter.R
import data.model.CountDown
import data.CountDownViewModel
import kotlinx.android.synthetic.main.fragment_countdown.view.*
import java.util.*

class CountDownFragment : Fragment() {
    var mCountDown: CountDown? = null
    companion object{
        private val ARG_ID: String = "uuid"

        fun newInstance(uuid: String):CountDownFragment {
            var bundle = Bundle()
            bundle.putSerializable(ARG_ID,uuid)
            return CountDownFragment().apply { arguments = bundle }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val viewModel = CountDownViewModel(application = context?.applicationContext as Application)
        val id = arguments?.getSerializable(ARG_ID).toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_countdown,container,false)

        val DateTimeTextview = view.countdown_date_time
        val TitleEdittext = view.countdown_title_edittext
        val setDateButton = view.button_set_date
        val setTimeButton = view.button_set_time

        return view;
    }
}