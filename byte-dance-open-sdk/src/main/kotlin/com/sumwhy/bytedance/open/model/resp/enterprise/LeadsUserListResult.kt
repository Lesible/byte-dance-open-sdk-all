package com.sumwhy.bytedance.open.model.resp.enterprise

import com.sumwhy.bytedance.open.model.universal.enterprise.enumeration.AppointmentTypeEnum

data class LeadsUserListResult(

    /**
     * 总个数
     */
    val totalCount: Int?,

    /**
     * 总页数
     */
    val totalPage: Int?,

    /**
     * 当前页码
     */
    val page: Int?,

    /**
     * 用户列表
     */
    val userList: List<UserInfo>?,
)

data class UserInfo(

    /**
     * 生日
     */
    val birthday: String? = null,

    /**
     * 客户来源-抖音号
     */
    val referUserAwemeUid: String? = null,

    /**
     * 互动来源，如XX转化页，整屋案例等
     */
    val actionSource: String? = null,

    /**
     * 地址
     */
    val address: String? = null,

    /**
     * 性别
     */
    val gender: Int? = null,

    /**
     * 客户来源-昵称
     */
    val referUserNickname: String? = null,

    /**
     * 备注
     */
    val remark: String? = null,

    /**
     * 手机号
     */
    val telephone: String? = null,

    /**
     * 头像
     */
    val avatar: String? = null,

    /**
     * 更新时间
     */
    val updateTime: Long? = null,

    /**
     * 抖音号
     */
    val awemeUid: String? = null,

    /**
     * 预约类型
     */
    val appointmentType: AppointmentTypeEnum? = null,

    /**
     *  用户 id
     */
    val intentionUserId: String? = null,

    /**
     * 绑定的标签列表
     */
    val tagList: List<Tag>? = null,

    /**
     * 额外字段
     */
    val extra: String? = null,

    /**
     * 用户昵称
     */
    val nickName: String? = null,

    /**
     * 姓名
     */
    val name: String? = null,

    /**
     * 所属落地页或者锚点 id
     */
    val sourceId: String? = null,

    /**
     * 粉丝类型
     */
    val isFollower: Boolean? = null,

    /**
     * 客户来源-角色
     */
    val referUserRole: String? = null,

    /**
     * 客户来源-uid
     */
    val referUserId: String? = null,

    /**
     * 城市编码
     */
    val cityCode: String? = null,

    /**
     * 年龄
     */
    val age: String? = null,

    )

data class Tag(

    /**
     * 标签 id
     */
    val tagId: String,

    /**
     * 标签名
     */
    val name: String,
)

