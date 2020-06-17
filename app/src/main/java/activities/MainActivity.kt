package activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.countdowncounter.R
import fragments.CountDownListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentmanger:FragmentManager = supportFragmentManager
        val fragment = fragmentmanger
            .findFragmentById(R.id.main_activity_container) ?: CountDownListFragment.newInstance()
        fragmentmanger.beginTransaction().add(R.id.main_activity_container,fragment).commit()
    }
}
