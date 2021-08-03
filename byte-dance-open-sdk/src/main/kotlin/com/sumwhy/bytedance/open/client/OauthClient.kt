package com.sumwhy.bytedance.open.client

import com.sumwhy.bytedance.open.api.OauthApi
import com.sumwhy.bytedance.open.common.OpenCredentials
import com.sumwhy.bytedance.open.model.resp.oauth.ByteDanceOauthResp

/**
 * <p> @date: 2021-07-28 11:35</p>
 * @author 何嘉豪
 */
class OauthClient(private val oauthApi: OauthApi, private val openCredentials: OpenCredentials) {

    /**
     *  刷新 accessToken
     *
     *  @param refreshToken refreshToken
     *  @param clientKey clientKey, 默认取配置文件配置
     *  @return ByteDanceOauthResp 字节开放平台授权结果 nullable
     */
    @JvmOverloads
    fun refreshToken(clientKey: String = openCredentials.key, refreshToken: String): ByteDanceOauthResp? {
        val queryMap = mutableMapOf(
            "grant_type" to "refresh_token",
            "client_key" to clientKey,
            "refresh_token" to refreshToken)
        val execute = oauthApi.refreshToken(queryMap).execute()
        return if (execute.isSuccessful) execute.body() else null
    }

}