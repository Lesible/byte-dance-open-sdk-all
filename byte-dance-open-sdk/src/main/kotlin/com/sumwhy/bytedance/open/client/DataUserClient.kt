package com.sumwhy.bytedance.open.client

import com.sumwhy.bytedance.open.api.DataApi
import com.sumwhy.bytedance.open.model.req.data.DataBaseParam
import com.sumwhy.bytedance.open.model.resp.ByteDanceResp
import com.sumwhy.bytedance.open.model.resp.data.user.*

/**
 * <p> 用户数据请求客户端 </p>
 * <p> create 2021-08-06 09:36 by lesible </p>
 *
 * @author 何嘉豪
 */
class DataUserClient(private val dataApi: DataApi) {

    fun getUserItem(dataBaseParam: DataBaseParam): ByteDanceResp<UserDataResult<UserItem>>? {
        val userItem = dataApi.getUserItem(dataBaseParam.toParamMap()).execute()
        return if (userItem.isSuccessful) userItem.body() else null
    }

    fun getUserFans(dataBaseParam: DataBaseParam): ByteDanceResp<UserDataResult<UserFan>>? {
        val userFans = dataApi.getUserFans(dataBaseParam.toParamMap()).execute()
        return if (userFans.isSuccessful) userFans.body() else null
    }

    fun getUserLike(dataBaseParam: DataBaseParam): ByteDanceResp<UserDataResult<UserLike>>? {
        val userLike = dataApi.getUserLike(dataBaseParam.toParamMap()).execute()
        return if (userLike.isSuccessful) userLike.body() else null
    }

    fun getUserComment(dataBaseParam: DataBaseParam): ByteDanceResp<UserDataResult<UserComment>>? {
        val userComment = dataApi.getUserComment(dataBaseParam.toParamMap()).execute()
        return if (userComment.isSuccessful) userComment.body() else null
    }

    fun getUserShare(dataBaseParam: DataBaseParam): ByteDanceResp<UserDataResult<UserShare>>? {
        val userShare = dataApi.getUserShare(dataBaseParam.toParamMap()).execute()
        return if (userShare.isSuccessful) userShare.body() else null
    }

    fun getUserProfile(dataBaseParam: DataBaseParam): ByteDanceResp<UserDataResult<UserProfile>>? {
        val userProfile = dataApi.getUserProfile(dataBaseParam.toParamMap()).execute()
        return if (userProfile.isSuccessful) userProfile.body() else null
    }


}
