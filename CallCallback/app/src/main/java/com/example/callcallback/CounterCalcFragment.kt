package com.example.callcallback

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentActivity


class CounterCalcFragment : Fragment(), OnChangedListener {

    private var onPassDataThirdFragmentListener: OnPassDataThirdFragmentListener? = null
    private var thirdFragment = ThirdFragment()

    lateinit var counterTV: TextView
    lateinit var clickBtn: Button
    private var counter = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_counter_calc, container, false)
        counterTV = view.findViewById(R.id.counterTx)
        clickBtn = view.findViewById(R.id.click)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        clickBtn.setOnClickListener {
            onPassDataThirdFragmentListener?.onPassData(counter)
        }


    }
    fun addOnPassDataListener(onPassDataThirdFragmentListener:OnPassDataThirdFragmentListener){
        this.onPassDataThirdFragmentListener = onPassDataThirdFragmentListener
    }


    override fun onDecrement() {
        counter--
        counterTV.text = counter.toString()
     //  onPassDataThirdFragmentListener?.onPassData(counter)
    }

    override fun onIncrement() {
        counter++
        counterTV.text = counter.toString()
     //   onPassDataThirdFragmentListener?.onPassData(counter)
    }
    fun addFragment(){
        val frTransaction3FR = requireActivity().supportFragmentManager.beginTransaction()
        frTransaction3FR.add(R.id.container3, thirdFragment)
        frTransaction3FR.addToBackStack(null)
        frTransaction3FR.commit()
    }


}