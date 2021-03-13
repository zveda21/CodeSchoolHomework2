package com.example.appguardian.callservice

import com.example.appguardian.models.ditails.DitailsResponse
import com.example.appguardian.models.pojo.Content
import com.example.appguardian.models.pojo.Description
import com.example.appguardian.models.pojo.Section
import com.example.appguardian.models.sections.SectionResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


interface SearchRepository {
    fun sections(apiCallback: ApiCallback<Section>)
    fun currentSection(id: String?, apiCallback: ApiCallback<Description>)
    fun contentDefaultSearch(orderBy: String?, usedDate: String?, q: String?, apiCallback: ApiCallback<Content>
    )
}

class SearchRepositoryImpl(private val apiCalls: ApiCalls) : SearchRepository {
    override fun sections(apiCallback: ApiCallback<Section>) {
        apiCalls.getSections().enqueue(call(apiCallback))
    }

    override fun currentSection(id: String?, apiCallback: ApiCallback<Description>) {
        apiCalls.getCurrentPath(id).enqueue(call(apiCallback))
    }

    override fun contentDefaultSearch(orderBy: String?, usedDate: String?, q: String?, apiCallback: ApiCallback<Content>) {
        apiCalls.getContentSearch(orderBy = orderBy,usedDate = usedDate,q=q).enqueue(call(apiCallback))
    }

    private fun <T> call(apiCallback: ApiCallback<T>): Callback<T> {
        return object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                if (response.isSuccessful) {
                    apiCallback.onSuccess(response.body())
                } else {
                    apiCallback.onError(response.message())
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                apiCallback.onFailure(t)
            }

        }
    }


}