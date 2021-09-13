package com.sumwhy.bytedance.open.client

import com.sumwhy.bytedance.open.api.OauthApi
import com.sumwhy.bytedance.open.common.OpenCredentials
import com.sumwhy.bytedance.open.model.req.oauth.LarkOauthReq
import com.sumwhy.bytedance.open.model.resp.LarkOauthResult
import com.sumwhy.bytedance.open.model.resp.oauth.ByteDanceOauthResult
import com.sumwhy.bytedance.open.model.resp.oauth.RefreshTokenResult

/**
 * <p> @date: 2021-07-28 11:35</p>
 * @author 何嘉豪
 */
class OauthClient(private val oauthApi: OauthApi, private val openCredentials: OpenCredentials) {

    /**
     * 刷新 accessToken
     *
     * @param clientKey clientKey, 默认取配置文件配置
     * @param refreshToken refreshToken
     * @return 字节开放平台授权结果 nullable
     */
    @JvmOverloads
    fun refreshToken(
        clientKey: String = openCredentials.key,
        refreshToken: String,
    ): ByteDanceOauthResult<RefreshTokenResult>? {
        val queryMap = mapOf(
            "grant_type" to "refresh_token",
            "client_key" to clientKey,
            "refresh_token" to refreshToken)
        val execute = oauthApi.refreshToken(queryMap).execute()
        return if (execute.isSuccessful) execute.body() else null
    }

    /**
     * 刷新 refreshToken
     *
     * @param clientKey clientKey, 默认取配置文件配置
     * @param refreshToken refreshToken
     * @return 字节开放平台授权结果 nullable
     */
    @JvmOverloads
    fun renewRefreshToken(
        clientKey: String = openCredentials.key,
        refreshToken: String,
    ): ByteDanceOauthResult<RefreshTokenResult>? {
        val queryMap = mapOf(
            "client_key" to clientKey,
            "refresh_token" to refreshToken)
        val execute = oauthApi.renewRefreshToken(queryMap).execute()
        return if (execute.isSuccessful) execute.body() else null
    }

    /**
     * 获取 clientToken
     *
     * @param clientKey clientKey 默认取配置文件配置
     * @param clientSecret clientSecret 默认取配置文件配置
     * @return 字节开放平台授权结果 nullable
     */
    @JvmOverloads
    fun clientToken(
        clientKey: String = openCredentials.key,
        clientSecret: String = openCredentials.secret,
    ): ByteDanceOauthResult<RefreshTokenResult>? {
        val queryMap = mapOf(
            "grant_type" to "client_credential",
            "client_key" to clientKey,
            "client_secret" to clientSecret)
        val execute = oauthApi.clientToken(queryMap).execute()
        return if (execute.isSuccessful) execute.body() else null
    }


    /**
     * 飞书授权,用于小程序端
     *
     * @param larkCode 飞书授权码
     * @param clientToken 抖开 clientToken
     * @param larkAccessToken 飞书请求凭证
     * @return 飞书授权结果
     */
    fun larkAppOauth(larkCode: String, clientToken: String, larkAccessToken: String): LarkOauthResult? {
        val larkOauthReq = LarkOauthReq.builder(larkCode, clientToken, "app", larkAccessToken).build()
        val execute = oauthApi.larkOauth(larkOauthReq.toParamMap()).execute()
        return if (execute.isSuccessful) execute.body() else null
    }

}