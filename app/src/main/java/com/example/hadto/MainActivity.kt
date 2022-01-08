package com.example.hadto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hadto.bottom_Fragment.*
import com.example.hadto.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var homeFragment: HomeFragment
    private lateinit var caleFragment: CaleFragment
    private lateinit var timerFragment: TimerFragment
    private lateinit var tilFragment: TilFragment
    private lateinit var marketFragment: MarketFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_nav = findViewById<BottomNavigationView>(R.id.bottom_nav)
        val homeFragment = HomeFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.fragments_frame, homeFragment).commit()



        btn_nav.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.menu_home -> {
                    val homeFragment = HomeFragment.newInstance()
                    supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, homeFragment).commit()
                }
                R.id.menu_cale -> {
                    val caleFragment = CaleFragment.newInstance()
                    supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, caleFragment).commit()
                }
                R.id.menu_timer -> {
                    val timerFragment = TimerFragment.newInstance()
                    supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, timerFragment).commit()
                }
                R.id.menu_til -> {
                    val tilFragment = TilFragment.newInstance()
                    supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, tilFragment).commit()
                }
                R.id.menu_market -> {
                    val marketFragment = MarketFragment.newInstance()
                    supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, marketFragment).commit()
                }

            }
            return@setOnItemSelectedListener true
        }
    }
}