package com.sumwhy.bytedance.open.api

import com.sumwhy.bytedance.open.model.resp.LarkOauthResult
import com.sumwhy.bytedance.open.model.resp.oauth.AccessTokenResult
import com.sumwhy.bytedance.open.model.resp.oauth.ByteDanceOauthResult
import com.sumwhy.bytedance.open.model.resp.oauth.RefreshTokenResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.QueryMap

/**
 * <p> @date: 2021-07-27 21:51</p>
 * @author 何嘉豪
 */
interface OauthApi {

    @GET("oauth/access_token/")
    fun accessToken(@QueryMap queryMap: Map<String, String>): Call<ByteDanceOauthResult<AccessTokenResult>>

    /**
     * 刷新 accessToken
     */
    @GET("oauth/refresh_token/")
    fun refreshToken(@QueryMap queryMap: Map<String, String>): Call<ByteDanceOauthResult<RefreshTokenResult>>

    /**
     * 刷新 refreshToken
     */
    @GET("oauth/renew_refresh_token/")
    fun renewRefreshToken(@QueryMap queryMap: Map<String, String>): Call<ByteDanceOauthResult<RefreshTokenResult>>

    /**
     * 获取 clientToken
     */
    @GET("oauth/client_token/")
    fun clientToken(@QueryMap queryMap: Map<String, String>): Call<ByteDanceOauthResult<RefreshTokenResult>>

    /**
     * 获取飞书授权
     */
    @POST("auth/scope/")
    fun larkOauth(@QueryMap queryMap: Map<String, String>): Call<LarkOauthResult>

}