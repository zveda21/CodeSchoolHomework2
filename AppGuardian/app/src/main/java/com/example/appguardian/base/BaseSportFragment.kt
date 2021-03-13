package com.example.appguardian.base

import androidx.fragment.app.Fragment

abstract class BaseSportFragment: Fragment() {
    abstract fun startLoader()
    abstract fun stopLoader()
}