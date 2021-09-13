package com.sumwhy.bytedance.open.api

import com.sumwhy.bytedance.open.model.resp.ByteDanceResp
import com.sumwhy.bytedance.open.model.resp.oauth.ByteDanceOauthResult
import com.sumwhy.bytedance.open.model.resp.user.ListFansResult
import com.sumwhy.bytedance.open.model.resp.user.UserInfoResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

/**
 * <p> 用户管理接口 </p>
 * <p> create 2021-08-06 17:13 by lesible </p>
 * @author 何嘉豪
 */
interface UserApi {

    /**
     * 查询用户粉丝列表
     */
    @GET("fans/list/")
    fun listFans(@QueryMap queryMap: Map<String, String>): Call<ByteDanceResp<ListFansResult>>

    /**
     * 查询用户信息
     */
    @GET("oauth/userinfo/")
    fun userInfo(@Query("access_token") accessToken: String, @Query("open_id") openId: String)
            : Call<ByteDanceOauthResult<UserInfoResult>>


}