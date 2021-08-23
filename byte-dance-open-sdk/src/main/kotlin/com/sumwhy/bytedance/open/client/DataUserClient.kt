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

    /**
     * 查询用户视频信息
     *
     * @param userDataParam 用户数据查询参数
     */
    fun getUserItem(userDataParam: UserDataParam): ByteDanceResp<UserDataResult<UserItem>>? {
        val userItem = dataApi.getUserItem(userDataParam.toParamMap()).execute()
        return if (userItem.isSuccessful) userItem.body() else null
    }

    /**
     * 查询用户粉丝信息
     *
     * @param userDataParam 用户数据查询参数
     */

    fun getUserFans(userDataParam: UserDataParam): ByteDanceResp<UserDataResult<UserFan>>? {
        val userFans = dataApi.getUserFans(userDataParam.toParamMap()).execute()
        return if (userFans.isSuccessful) userFans.body() else null
    }

    /**
     * 查询用户点赞信息
     *
     * @param userDataParam 用户数据查询参数
     */
    fun getUserLike(userDataParam: UserDataParam): ByteDanceResp<UserDataResult<UserLike>>? {
        val userLike = dataApi.getUserLike(userDataParam.toParamMap()).execute()
        return if (userLike.isSuccessful) userLike.body() else null
    }

    /**
     * 查询用户评论信息
     *
     * @param userDataParam 用户数据查询参数
     */
    fun getUserComment(userDataParam: UserDataParam): ByteDanceResp<UserDataResult<UserComment>>? {
        val userComment = dataApi.getUserComment(userDataParam.toParamMap()).execute()
        return if (userComment.isSuccessful) userComment.body() else null
    }

    /**
     * 查询用户分享信息
     *
     * @param userDataParam 用户数据查询参数
     */
    fun getUserShare(userDataParam: UserDataParam): ByteDanceResp<UserDataResult<UserShare>>? {
        val userShare = dataApi.getUserShare(userDataParam.toParamMap()).execute()
        return if (userShare.isSuccessful) userShare.body() else null
    }

    /**
     * 查询用户主页信息
     *
     * @param userDataParam 用户数据查询参数
     */
    fun getUserProfile(userDataParam: UserDataParam): ByteDanceResp<UserDataResult<UserProfile>>? {
        val userProfile = dataApi.getUserProfile(userDataParam.toParamMap()).execute()
        return if (userProfile.isSuccessful) userProfile.body() else null
    }


}
