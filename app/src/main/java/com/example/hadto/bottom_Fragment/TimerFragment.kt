package com.example.hadto.bottom_Fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hadto.R

class TimerFragment: Fragment() {

    companion object {
        const val TAG: String = "로그"

        fun newInstance() : TimerFragment {
            return TimerFragment()
        }
    }

    //메모리에 올라 갔을때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    // 프레그먼트를 안고 있는 엑티비티 붙었을 때
    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    //프레그먼트와 레이아웃 연결
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_timer, container, false)

    }

}