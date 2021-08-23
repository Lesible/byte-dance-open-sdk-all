package com.sumwhy.bytedance.open.client

import com.sumwhy.bytedance.open.api.UserApi
import com.sumwhy.bytedance.open.model.req.UniversalListParam
import com.sumwhy.bytedance.open.model.resp.ByteDanceResp
import com.sumwhy.bytedance.open.model.resp.user.ListFansResult

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
     */
    fun listFans(universalListParam: UniversalListParam): ByteDanceResp<ListFansResult>? {
        val listFansQuery = userApi.listFans(universalListParam.toParamMap())
        return listFansQuery.execute().body()
    }

}