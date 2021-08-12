package com.sumwhy.bytedance.open.model.resp.user

import com.sumwhy.bytedance.open.model.resp.BaseData

/**
 * <p> 粉丝信息列表结果 </p>
 * <p> create 2021-08-06 17:07 by lesible </p>
 * @author 何嘉豪
 */
data class ListFansResult(

    /**
     * 用于下一页请求的cursor
     */
    val cursor: Long?,

    /**
     * 是否还有数据
     */
    val hasMore: Boolean?,

    /**
     * 粉丝总数
     */
    val total: Long?,

    /**
     * 由于置顶的原因, list长度可能比count指定的数量多一些或少一些。
     */
    val list: List<FansInfo>?,

    /**
     * 错误码
     */
    override val errorCode: Int,

    /**
     * 错误码描述
     */
    override val description: String,
) : BaseData(errorCode, description)

data class FansInfo(

    /**
     * 用户在当前应用的唯一标识
     */
    private var openId: String,

    /**
     * 用户在当前开发者账号下的唯一标识（未绑定开发者账号没有该字段）
     */
    private val unionId: String?,

    /**
     * 昵称
     */
    private val nickname: String?,

    /**
     * 头像
     */
    private val avatar: String?,

    /**
     * 城市
     */
    private val city: String,

    /**
     * 省份
     */
    private val province: String?,

    /**
     * 镇
     */
    private val country: String?,

    /**
     * 性别 0 未知 1 男性 2 女性
     */
    private val gender: Int,
)