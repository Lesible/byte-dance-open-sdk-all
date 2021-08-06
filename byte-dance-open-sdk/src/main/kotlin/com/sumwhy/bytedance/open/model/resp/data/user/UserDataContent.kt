package com.sumwhy.bytedance.open.model.resp.data.user

/**
 * <p> 用户数据集合内部类型 </p>
 * <p> create 2021-08-06 10:49 by lesible </p>
 * @author 何嘉豪
 */

open class UserDataBaseContent(

    /**
     * 日期
     */
    open val date: String,
)

data class UserComment(

    /**
     * 日期
     */
    override val date: String,

    /**
     * 新增评论
     */
    val newComment: Int,
) : UserDataBaseContent(date)

data class UserFan(

    /**
     * 日期
     */
    override val date: String,

    /**
     * 每日总粉丝数
     */
    val totalFans: Int,

    /**
     * 每天新粉丝数
     */
    val newFans: Int,
) : UserDataBaseContent(date)

data class UserItem(

    /**
     * 日期
     */
    override val date: String,

    /**
     * 每天新增视频播放
     */
    val newPlay: Int,

    /**
     * 每日内容总数
     */
    val totalIssue: Int,

    /**
     * 每日发布内容数
     */
    val newIssue: Int,
) : UserDataBaseContent(date)

data class UserLike(

    /**
     * 日期
     */
    override val date: String,

    /**
     * 新增点赞
     */
    val newLike: Int,
) : UserDataBaseContent(date)

data class UserProfile(

    /**
     * 日期
     */
    override val date: String,

    /**
     * 当日个人主页访问人数
     */
    val profileUv: Int,
) : UserDataBaseContent(date)

data class UserShare(

    /**
     * 日期
     */
    override val date: String,

    /**
     * 	新增分享
     */
    val newShare: Int,
) : UserDataBaseContent(date)
