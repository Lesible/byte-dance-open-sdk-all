package com.sumwhy.bytedance.open.api

import com.sumwhy.bytedance.open.model.resp.ByteDanceResp
import com.sumwhy.bytedance.open.model.resp.video.ListVideoResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.QueryMap

/**
 * <p> 视频管理接口列表 </p>
 * <p> create 2021-08-02 11:25 by lesible</p>
 * @author 何嘉豪
 */
interface VideoApi {

    @POST("video/upload/")
    fun uploadVideo(
        @Query("open_id") openId: String,
        @Query("access_token") accessToken: String,
    )

    /**
     * 查询用户视频列表
     */
    @GET("video/list/")
    fun listVideo(@QueryMap queryMap: Map<String, String>): Call<ByteDanceResp<ListVideoResult>>

}