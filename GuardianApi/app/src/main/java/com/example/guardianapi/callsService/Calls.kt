package com.example.guardianapi.callsService
import com.example.guardianapi.models.ResponseSearchContent
import com.example.guardianapi.utils.Constants.Companion.API_KEY
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface Calls {
    @Headers("api-key:$API_KEY")
    @GET("/search")
    fun getSearchContentItem(
        @Query("q") fieldSearch:String,
        @Query("section") section: String="",
        @Query("show-rights") showRights: String="" ,
        @Query("tag") tag: String="",
        @Query("page") page: Int=1,
        @Query("production-office") productionOffice: String="",
        @Query("page-size") pageSize: Int=1,
        @Query("rights") rights: String="",
        @Query("order-by") orderBy: String="",
        @Query("show-tags") showTags: String="",
        @Query("use-date") useDate: String="",
        @Query("show-elements") showElements: String="",
        @Query("show-references") showReferences: String="",
        @Query("show-fields") showFields: String="",
        @Query("from-date") fromDate: String="",
        @Query("to-date") toDate: String=""
    ) :Call<ResponseSearchContent>

}