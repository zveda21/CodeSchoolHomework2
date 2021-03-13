package com.example.appguardian.callservice

import com.example.appguardian.callservice.ApiClient.API_KEY
import com.example.appguardian.models.ditails.DitailsResponse
import com.example.appguardian.models.pojo.Content
import com.example.appguardian.models.pojo.Description
import com.example.appguardian.models.pojo.Section
import com.example.appguardian.models.sections.SectionResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiCalls {
    @Headers("api-key:$API_KEY")
    @GET("sections")
    fun getSections(): Call<Section>

    @Headers("api-key:$API_KEY")
    @GET("{id}")
    fun getCurrentPath(
        @Path(value = "id") id: String?,
        @Query("show-fields") fields: String = "all"
    ): Call<Description>

    @Headers("api-key:$API_KEY")
    @GET("search")
    fun getContentSearch(
        @Query(value = "show-fields") fields: String = "all",
        @Query(value = "order-by") orderBy: String?,
        @Query(value = "use-date") usedDate: String?,
        @Query(value = "q") q: String?
    ): Call<Content>
}