package com.sumwhy.bytedance.open.api

import com.sumwhy.bytedance.open.model.req.video.VideoDataReq
import com.sumwhy.bytedance.open.model.resp.ByteDanceResp
import com.sumwhy.bytedance.open.model.resp.video.ListVideoResult
import retrofit2.Call
import retrofit2.http.*

/**
 * <p> 视频管理接口列表 </p>
 * <p> create 2021-08-02 11:25 by lesible</p>
 * @author 何嘉豪
 */
interface VideoApi {

    /**
     * 查询用户视频列表
     */
    @GET("video/list/")
    fun listVideo(@QueryMap queryMap: Map<String, String>): Call<ByteDanceResp<ListVideoResult>>

    /**
     * 查询指定视频数据
     */
    @POST("video/data/")
    fun videoData(
        @Query("open_id") openId: String,
        @Query("access_token") accessToken: String,
        @Body videoDataReq: VideoDataReq,
    ): Call<String>

}