package com.example.hadto.timerTapbar

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.hadto.bottom_Fragment.TimerFragment

class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
       return when(position) {
           0 -> {TimerFragment()}
           1 -> {GraphFragment()}
           else -> {return TreeFragment()}

       }
    }
}
