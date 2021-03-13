package com.example.guardianapi.callsService

interface ApiCallback<T>{
    fun onSuccess(response:T)
    fun onFailure(T:Throwable)
}