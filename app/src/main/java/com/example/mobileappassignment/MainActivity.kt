package com.example.mobileappassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.mobileappassignment.databinding.ActivityMainBinding
import fragment.EventFragment
import fragment.HistoryFragment
import fragment.ProfileFragment
import fragment.TimelineFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val eventFragment=EventFragment()
    private val timelineFragment=TimelineFragment()
    private val historyFragment=HistoryFragment()
    private val profileFragment=ProfileFragment()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        replaceFragment(this.eventFragment)

        findViewById<com.google.android.material.bottomnavigation.BottomNavigationView>(R.id.bottom_navigation).setOnItemSelectedListener{
            when(it.itemId){
                R.id.icon_event -> replaceFragment(eventFragment)
                R.id.icon_timeline -> replaceFragment(timelineFragment)
                R.id.icon_history -> replaceFragment(historyFragment)
                R.id.icon_profile -> replaceFragment(profileFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        if(fragment!=null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container,fragment)
            transaction.commit()
        }
    }
}