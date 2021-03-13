package com.example.callcallback

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class ThirdFragment : Fragment(), OnPassDataThirdFragmentListener {
    private  var countTV :TextView?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_third, container, false)
        countTV = view.findViewById(R.id.countTx)
        return view
    }

    override fun onPassData(count: Int) {
        countTV?.text = count.toString()
    }


//     fun showCount(count:Any){
//        countTV?.text = count.toString()
//    }


}