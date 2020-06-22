package activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.countdowncounter.R
import data.model.CountDown
import fragments.CountDownFragment

class CountDownActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_count_down)

        val fragmentmanger: FragmentManager = supportFragmentManager
        val fragment = fragmentmanger
            .findFragmentById(R.id.activity_countdown_container) ?: CountDownFragment.newInstance(
            CountDown().uuid.toString())
        fragmentmanger.beginTransaction().add(R.id.activity_countdown_container,fragment).commit()
    }

}
