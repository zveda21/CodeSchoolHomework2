package com.example.appguardian.callservice

interface ApiCallback<T>{
    fun onSuccess(data: T?)
    fun onError(error:String){}
    fun onFailure(error:Throwable){}
}