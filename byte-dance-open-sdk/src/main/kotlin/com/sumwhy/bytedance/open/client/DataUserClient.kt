package com.sumwhy.bytedance.open.client

import com.sumwhy.bytedance.open.api.DataApi
import com.sumwhy.bytedance.open.model.req.data.DataBaseParam

/**
 * <p> 用户数据请求客户端 </p>
 * <p> create 2021-08-06 09:36 by lesible </p>
 *
 * @author 何嘉豪
 */
class DataUserClient(private val dataApi: DataApi) {

    fun getUserItem(dataBaseParam: DataBaseParam) {
        val userItem = dataApi.getUserItem(dataBaseParam.toParamMap()).execute()
        println(if (userItem.isSuccessful) userItem.body() else null)
    }

    fun getUserFans(dataBaseParam: DataBaseParam) {
        val userFans = dataApi.getUserFans(dataBaseParam.toParamMap()).execute()
        println(if (userFans.isSuccessful) userFans.body() else null)
    }

    fun getUserLike(dataBaseParam: DataBaseParam) {
        val userLike = dataApi.getUserLike(dataBaseParam.toParamMap()).execute()
        println(if (userLike.isSuccessful) userLike.body() else null)
    }

    fun getUserComment(dataBaseParam: DataBaseParam) {
        val userComment = dataApi.getUserComment(dataBaseParam.toParamMap()).execute()
        println(if (userComment.isSuccessful) userComment.body() else null)
    }

    fun getUserShare(dataBaseParam: DataBaseParam) {
        val userShare = dataApi.getUserShare(dataBaseParam.toParamMap()).execute()
        println(if (userShare.isSuccessful) userShare.body() else null)
    }

    fun getUserProfile(dataBaseParam: DataBaseParam) {
        val userProfile = dataApi.getUserProfile(dataBaseParam.toParamMap()).execute()
        println(if (userProfile.isSuccessful) userProfile.body() else null)
    }


}
