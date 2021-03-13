package com.example.recyclerviewwithfewholders.models

import java.io.Serializable

data class Status(val statusText: String,  val statusTitle: String) : News(statusTitle), Serializable
