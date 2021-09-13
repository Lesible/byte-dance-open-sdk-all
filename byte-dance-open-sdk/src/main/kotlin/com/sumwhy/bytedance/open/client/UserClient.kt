package com.sumwhy.bytedance.open.client

import com.sumwhy.bytedance.open.api.UserApi
import com.sumwhy.bytedance.open.model.req.UniversalListParam
import com.sumwhy.bytedance.open.model.resp.ByteDanceResp
import com.sumwhy.bytedance.open.model.resp.oauth.ByteDanceOauthResult
import com.sumwhy.bytedance.open.model.resp.user.ListFansResult
import com.sumwhy.bytedance.open.model.resp.user.UserInfoResult

/**
 * <p> 用户管理请求客户端 </p>
 * <p> create 2021-08-06 17:14 by lesible </p>
 * @author 何嘉豪
 */
class UserClient(private val userApi: UserApi) {

    /**
     * 列出指定用户的粉丝
     *
     * @param universalListParam 通用列表查询参数
     * @return 用户粉丝信息
     */
    fun listFans(universalListParam: UniversalListParam): ByteDanceResp<ListFansResult>? {
        val listFansQuery = userApi.listFans(universalListParam.toParamMap()).execute()
        return if (listFansQuery.isSuccessful) listFansQuery.body() else null
    }

    /**
     * 查询用户信息
     *
     * @param accessToken 请求凭证
     * @param openId 用户唯一标识
     * @return 用户信息
     */
    fun userInfo(accessToken: String, openId: String): ByteDanceOauthResult<UserInfoResult>? {
        val userInfo = userApi.userInfo(accessToken, openId).execute()
        return if (userInfo.isSuccessful) userInfo.body() else null
    }

}