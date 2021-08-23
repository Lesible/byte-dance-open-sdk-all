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

    /**
     * 获取用户视频数
     */
    @GET("data/external/user/item/")
    fun getUserItem(@QueryMap queryMap: Map<String, String>): Call<ByteDanceResp<UserDataResult<UserItem>>>

    /**
     * 获取用户粉丝数
     */
    @GET("data/external/user/fans/")
    fun getUserFans(@QueryMap queryMap: Map<String, String>): Call<ByteDanceResp<UserDataResult<UserFan>>>

    /**
     * 获取用户点赞数
     */
    @GET("data/external/user/like/")
    fun getUserLike(@QueryMap queryMap: Map<String, String>): Call<ByteDanceResp<UserDataResult<UserLike>>>

    /**
     * 获取用户评价数
     */
    @GET("data/external/user/comment/")
    fun getUserComment(@QueryMap queryMap: Map<String, String>): Call<ByteDanceResp<UserDataResult<UserComment>>>

    /**
     * 获取用户分享数
     */
    @GET("data/external/user/share/")
    fun getUserShare(@QueryMap queryMap: Map<String, String>): Call<ByteDanceResp<UserDataResult<UserShare>>>

    /**
     * 获取用户主页信息
     */
    @GET("data/external/user/profile/")
    fun getUserProfile(@QueryMap queryMap: Map<String, String>): Call<ByteDanceResp<UserDataResult<UserProfile>>>

    /**
     * 获取用户视频基本信息
     */
    @GET("data/external/item/base/")
    fun getItemBase(@QueryMap queryMap: Map<String, String>): Call<String>

    /**
     * 获取用户视频播放信息
     */
    @GET("data/external/item/play/")
    fun getItemPlay(@QueryMap queryMap: Map<String, String>): Call<String>
}