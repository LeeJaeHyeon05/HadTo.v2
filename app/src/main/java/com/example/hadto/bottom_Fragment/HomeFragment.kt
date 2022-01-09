package com.example.hadto.bottom_Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hadto.R

class HomeFragment: Fragment() {

    companion object {
        const val TAG: String = "로그"

        fun newInstance() : HomeFragment {
            return HomeFragment()
        }
    }

    //프레그먼트와 레이아웃 연결
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

}