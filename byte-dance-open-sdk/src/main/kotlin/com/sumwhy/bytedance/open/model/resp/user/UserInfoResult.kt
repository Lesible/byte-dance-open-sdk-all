package com.sumwhy.bytedance.open.model.resp.user

import com.sumwhy.bytedance.open.model.resp.BaseData

data class UserInfoResult(

    /**
     * 国家
     */
    val country: String?,

    /**
     * 性别
     */
    val gender: Int?,

    /**
     * 城市
     */
    val city: String?,

    /**
     * openId
     */
    val openId: String?,

    /**
     * 头像
     */
    val avatar: String?,

    /**
     * 企业号角色
     */
    val eAccountRole: String?,

    /**
     * 大头像
     */
    val avatarLarger: String?,

    /**
     * clientKey
     */
    val clientKey: String?,

    /**
     * 省份
     */
    val province: String?,

    /**
     * ?
     */
    val captcha: String?,

    /**
     * 区
     */
    val district: String?,

    /**
     * 昵称
     */
    val nickname: String?,

    /**
     * 用户在当前开发者账号下的唯一标识
     */
    val unionId: String?,

    /**
     * logId
     */
    val logId: String?,
    /**
     * 描述 url
     */
    val descUrl: String?,
    override val description: String,
    override val errorCode: Int,
) : BaseData(errorCode, description)


