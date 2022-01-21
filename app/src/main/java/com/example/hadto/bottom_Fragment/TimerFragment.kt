package com.example.hadto.bottom_Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.hadto.R
import com.example.hadto.databinding.FragmentTimerBinding
import com.example.hadto.timerTapbar.tabGraphFragment
import com.example.hadto.timerTapbar.tabTimerFragment
import com.google.android.material.tabs.TabLayoutMediator
import java.text.SimpleDateFormat
import java.util.*
import kotlin.concurrent.timer

class TimerFragment: Fragment() {

    companion object {
        const val TAG: String = "로그"

        fun newInstance() : TimerFragment {
            return TimerFragment()
        }
    }
    //뷰바인딩
    private var mBinding: FragmentTimerBinding? = null
    private val binding get() = mBinding!!


    //프레그먼트와 레이아웃 연결
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentTimerBinding.inflate(inflater, container, false)


        val timerFragment = tabTimerFragment()
        val graphFragment = tabGraphFragment()

        val fragments = arrayListOf<Fragment>(timerFragment, graphFragment)


        val tabAdapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int {
                return fragments.size
            }

            override fun createFragment(position: Int): Fragment {
                return fragments[position]
            }

        }

        binding.viewPager2.adapter = tabAdapter

        TabLayoutMediator(binding.tabsMain, binding.viewPager2) {tab, position ->
            when(position) {
                0 -> tab.setText(R.string.timerTapText)
                else -> tab.setText(R.string.graphTapText)
            }
        }.attach()


        //현재 날짜 보여주기
        val currentTime : Long = System.currentTimeMillis()
        val dataFormat = SimpleDateFormat("yyyy-MM-dd")
        binding.dateText.text = dataFormat.format(currentTime)


        return binding.root
    }

    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }

}