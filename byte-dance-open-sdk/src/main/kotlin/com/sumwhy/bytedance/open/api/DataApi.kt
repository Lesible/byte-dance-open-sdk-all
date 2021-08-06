package com.sumwhy.bytedance.open.api

import com.sumwhy.bytedance.open.model.resp.ByteDanceResp
import com.sumwhy.bytedance.open.model.resp.data.user.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * <p> 数据开放服务 </p>
 * <p> create 2021-08-06 09:28 by lesible </p>
 * @author 何嘉豪
 */
interface DataApi {

    @GET("data/external/user/item/")
    fun getUserItem(@QueryMap queryMap: Map<String, String>): Call<ByteDanceResp<UserDataResult<UserItem>>>

    @GET("data/external/user/fans/")
    fun getUserFans(@QueryMap queryMap: Map<String, String>): Call<ByteDanceResp<UserDataResult<UserFan>>>

    @GET("data/external/user/like/")
    fun getUserLike(@QueryMap queryMap: Map<String, String>): Call<ByteDanceResp<UserDataResult<UserLike>>>

    @GET("data/external/user/comment/")
    fun getUserComment(@QueryMap queryMap: Map<String, String>): Call<ByteDanceResp<UserDataResult<UserComment>>>

    @GET("data/external/user/share/")
    fun getUserShare(@QueryMap queryMap: Map<String, String>): Call<ByteDanceResp<UserDataResult<UserShare>>>

    @GET("data/external/user/profile/")
    fun getUserProfile(@QueryMap queryMap: Map<String, String>): Call<ByteDanceResp<UserDataResult<UserProfile>>>


}