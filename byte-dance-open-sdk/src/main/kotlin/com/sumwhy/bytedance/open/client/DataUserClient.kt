package com.sumwhy.bytedance.open.client

import com.sumwhy.bytedance.open.api.DataApi
import com.sumwhy.bytedance.open.model.req.data.external.UserDataParam
import com.sumwhy.bytedance.open.model.resp.ByteDanceResp
import com.sumwhy.bytedance.open.model.resp.data.user.*

/**
 * <p> 用户数据请求客户端 </p>
 * <p> create 2021-08-06 09:36 by lesible </p>
 *
 * @author 何嘉豪
 */
class DataUserClient(private val dataApi: DataApi) {

    fun getUserItem(UserDataParam: UserDataParam): ByteDanceResp<UserDataResult<UserItem>>? {
        val userItem = dataApi.getUserItem(UserDataParam.toParamMap()).execute()
        return if (userItem.isSuccessful) userItem.body() else null
    }

    fun getUserFans(UserDataParam: UserDataParam): ByteDanceResp<UserDataResult<UserFan>>? {
        val userFans = dataApi.getUserFans(UserDataParam.toParamMap()).execute()
        return if (userFans.isSuccessful) userFans.body() else null
    }

    fun getUserLike(UserDataParam: UserDataParam): ByteDanceResp<UserDataResult<UserLike>>? {
        val userLike = dataApi.getUserLike(UserDataParam.toParamMap()).execute()
        return if (userLike.isSuccessful) userLike.body() else null
    }

    fun getUserComment(UserDataParam: UserDataParam): ByteDanceResp<UserDataResult<UserComment>>? {
        val userComment = dataApi.getUserComment(UserDataParam.toParamMap()).execute()
        return if (userComment.isSuccessful) userComment.body() else null
    }

    fun getUserShare(UserDataParam: UserDataParam): ByteDanceResp<UserDataResult<UserShare>>? {
        val userShare = dataApi.getUserShare(UserDataParam.toParamMap()).execute()
        return if (userShare.isSuccessful) userShare.body() else null
    }

    fun getUserProfile(UserDataParam: UserDataParam): ByteDanceResp<UserDataResult<UserProfile>>? {
        val userProfile = dataApi.getUserProfile(UserDataParam.toParamMap()).execute()
        return if (userProfile.isSuccessful) userProfile.body() else null
    }


}
