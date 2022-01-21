package com.example.hadto.timerTapbar

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hadto.R
import com.example.hadto.databinding.FragmentTabTimerBinding
import java.text.SimpleDateFormat
import java.util.*
import kotlin.concurrent.timer

class tabTimerFragment : Fragment() {

    //전역 변수로 바인딩 객체 선언
    private var mBinding: FragmentTabTimerBinding? = null
    //편의성을 위한 바인딩 변수 재 선언
    private val binding get() = mBinding!!

    //타이머 코드
    private var time = 0
    private var timerTask : Timer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentTabTimerBinding.inflate(inflater, container, false)

        //스타트 버튼
        binding.startBtn.setOnClickListener {
            startTimer()
            binding.startBtn.setOnClickListener(null)
        }
        //휴식 버튼
        binding.stopBtn.setOnClickListener {
            stopTimer()
        }
        //캔슬(리셋) 버튼
        binding.cancelBtn.setOnClickListener {
            resetTimer()
            val laptime = time
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

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }
}