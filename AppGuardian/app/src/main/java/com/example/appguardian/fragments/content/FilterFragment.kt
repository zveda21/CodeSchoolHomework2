package com.example.appguardian.fragments.content

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.DialogFragment
import com.example.appguardian.R
import com.example.appguardian.databinding.FragmentFilterBinding
import java.io.Serializable


class FilterFragment (): DialogFragment(), AdapterView.OnItemSelectedListener {

    private lateinit var filterBinding: FragmentFilterBinding
    private lateinit var passDataFromDialog: PassDataFromDialog
    private var currentContentItem : String = ""
    private var orderBy : String = ""
    private var useDate : String = ""


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        filterBinding = FragmentFilterBinding.inflate(inflater, container, false)
        return filterBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        filterBinding.contentSpinner.onItemSelectedListener = this
        filterBinding.orderSpinner.onItemSelectedListener = this
        filterBinding.useDateSpinner.onItemSelectedListener = this
        onResetSpinners()
        onClickSearchButton()

    }


    override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
        when(parent.id){
            R.id.contentSpinner->{
                currentContentItem = parent.getItemAtPosition(position).toString()
            }
            R.id.orderSpinner->{
                orderBy =  parent.getItemAtPosition(position).toString()
            }
            R.id.useDateSpinner->{
                useDate = parent.getItemAtPosition(position).toString()
            }
        }
    }
    override fun onNothingSelected(p0: AdapterView<*>?) {
    }

    private fun onClickSearchButton(){
        filterBinding.searchBtn.setOnClickListener {
            passDataFromDialog.passData(PassedDate(currentContentItem,orderBy,useDate))
            resetSpinner()
            dismiss()
        }
    }
    private fun onResetSpinners(){
        filterBinding.resetBtn.setOnClickListener {
            resetSpinner()
        }
    }
    private fun resetSpinner(){
        filterBinding.contentSpinner.setSelection(0)
        filterBinding.orderSpinner.setSelection(0)
        filterBinding.useDateSpinner.setSelection(0)
    }

     fun setPassDateInt(passDataFromDialog: PassDataFromDialog){
        this.passDataFromDialog = passDataFromDialog
    }
    companion object {
        fun newInstance() = FilterFragment()
    }
}
interface PassDataFromDialog{
    fun passData(data:PassedDate)
}

data class PassedDate( val contentItem:String, val orderBy:String, val useDate:String):Serializable