package com.sumwhy.bytedance.open.model.resp.data.video

/**
 * <p>  </p>
 * <p> create 2021-09-14 10:39 by lesible </p>
 * @author 何嘉豪
 */
open class VideoDataBaseContent(

    /**
     * 日期
     */
    open val date: String,
)

/**
 * 视频点赞
 */
data class VideoLike(

    /**
     * 日期
     */
    override val date: String,

    /**
     * 点赞数目
     */
    val like: Int,
) : VideoDataBaseContent(date)

/**
 * 视频播放
 */
data class VideoPlay(

    /**
     * 日期
     */
    override val date: String,

    /**
     * 播放数目
     */
    val play: Int,
) : VideoDataBaseContent(date)

/**
 * 视频评论
 */
data class VideoComment(

    /**
     * 日期
     */
    override val date: String,

    /**
     * 评论数目
     */
    val comment: Int,
) : VideoDataBaseContent(date)

/**
 * 视频分享
 */
data class VideoShare(

    /**
     * 日期
     */
    override val date: String,

    /**
     * 分享数目
     */
    val share: Int,
) : VideoDataBaseContent(date)

