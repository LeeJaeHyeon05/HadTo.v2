package com.example.hadto.bottom_Fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hadto.R
import com.example.hadto.databinding.FragmentTimerBinding
import java.text.SimpleDateFormat
import java.util.*
import kotlin.concurrent.timer
import kotlin.concurrent.timerTask

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

    private var time = 0
    private var timerTask : Timer? = null

    //프레그먼트와 레이아웃 연결
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentTimerBinding.inflate(inflater, container, false)


        val currentTime : Long = System.currentTimeMillis()
        val dataFormat = SimpleDateFormat("yyyy-MM-dd")

        //현재 날짜
        binding.dateText.text = dataFormat.format(currentTime)

        //스타트 버튼
        binding.startBtn.setOnClickListener {
            startTimer()
            binding.startBtn.setOnClickListener(null)
        }
        //휴식 버튼
        binding.restBtn.setOnClickListener {
            stopTimer()
        }
        //캔슬(리셋) 버튼
        binding.cancelBtn.setOnClickListener {
            resetTimer()
        }

        return binding.root
    }
    private fun startTimer() {
        timerTask = timer(period = 20) {
            time ++

            val hour = time / 3600 / 60
            val min = time / 3600
            val sec = (time % 3600) / 60

            activity?.runOnUiThread {
                binding.timerNum.text = "%1$02d:%2$02d:%3$02d".format(hour, min, sec)
            }
        }
    }
    private fun stopTimer() {
        timerTask?.cancel()
    }
    private fun resetTimer() {
        timerTask?.cancel()
        time = 0
        binding.timerNum.text = R.string.timerZeroText.toString()
    }


//    private fun timeToText(time: Int = 0) : String? {
//        return if (time < 0) {
//            null
//        } else if (time == 0) {
//            "00:00:00"
//        } else {
//            val hour = time /3600
//            val min = time % 3600 / 60
//            val sec = time % 60
//            "%1$02d:%2$02d:%3$02d".format(hour, min, sec)
//        }
//    }


    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }

}