package com.example.recyclerviewwithfewholders.models

import android.net.Uri
import java.io.Serializable

data class Media(val mediaImg: Uri?, val mediaTitle: String):News(mediaTitle),Serializable
