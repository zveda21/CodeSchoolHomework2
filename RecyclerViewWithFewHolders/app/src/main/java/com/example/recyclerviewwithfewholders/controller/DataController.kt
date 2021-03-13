package com.example.recyclerviewwithfewholders.controller

import com.example.recyclerviewwithfewholders.models.News

object DataController {
    private val mediaList: MutableList<News> = mutableListOf()


    fun addMedia(news: News) {
        mediaList.add(news)
    }

    fun deleteMedia(news: News) {
        mediaList.remove(news)
    }

}