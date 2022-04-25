package com.zs.home.network.api

import retrofit2.http.GET
import com.zs.home.network.dto.news.NewsListDTO
import com.zs.home.network.dto.news.NewsChannelsDTO
import io.reactivex.Observable
import retrofit2.http.Query

interface NewsApi {
    @GET("release/news")
    fun getNewsContents(
        @Query("channelId") channelId: String?,
        @Query("channelName") channelName: String?,
        @Query("page") page: String?
    ): Observable<NewsListDTO?>

    @GET("release/channel")
    fun getNewsChannels(): Observable<NewsChannelsDTO?>
}