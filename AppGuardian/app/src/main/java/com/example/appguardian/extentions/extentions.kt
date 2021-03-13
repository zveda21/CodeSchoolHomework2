package com.example.appguardian.extentions

import android.annotation.SuppressLint
import android.view.View
import android.widget.ProgressBar
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.appguardian.R

@SuppressLint("ResourceType")
fun AppCompatActivity.replaceFragmentBackStack(
    fragment: Fragment,
    @LayoutRes fragLayId: Int = R.id.childContainer,
    tag: String? = null
) {

    val fragmentTransaction = supportFragmentManager.beginTransaction()
    fragmentTransaction.apply {
        replace(fragLayId, fragment)
        addToBackStack(tag)
        commit()
    }

}

@SuppressLint("ResourceType")
fun AppCompatActivity.replaceFragmentNoBackStack(
    fragment: Fragment, @LayoutRes fragLayId: Int = R.id.childContainer,
    tag: String? = null
) {

    val fragmentTransaction = supportFragmentManager.beginTransaction()
    fragmentTransaction.apply {
        replace(fragLayId, fragment)
        commit()
    }

}
