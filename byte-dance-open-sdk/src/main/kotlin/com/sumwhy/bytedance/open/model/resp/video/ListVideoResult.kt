package com.sumwhy.bytedance.open.model.resp.video

import com.sumwhy.bytedance.open.model.resp.BaseData

/**
 * <p>  </p>
 * <p> create 2021-08-02 14:58 by lesible</p>
 * @author 何嘉豪
 */
data class ListVideoResult(

    /**
     * 用于下一页请求的cursor
     */
    val cursor: Long? = null,

    /**
     * 是否还有数据
     */
    val hasMore: Boolean? = null,

    /**
     * 由于置顶的原因, list长度可能比count指定的数量多一些或少一些。
     */
    val list: List<VideoInfo>? = null,

    /**
     * 错误码
     */
    override val errorCode: Int,

    /**
     * 错误码描述
     */
    override val description: String,
) : BaseData(errorCode, description)

data class Statistics(

    /**
     * 评论数
     */
    val commentCount: Int,

    /**
     * 分享数
     */
    val shareCount: Int,

    /**
     * 点赞数
     */
    val diggCount: Int,

    /**
     * 转发数
     */
    val forwardCount: Int,

    /**
     * 播放数，只有作者本人可见。公开视频设为私密后，播放数也会返回0。
     */
    val playCount: Int,

    /**
     * 下载数
     */
    val downloadCount: Int,
)

data class VideoInfo(

    /**
     * 视频封面
     */
    val cover: String,

    /**
     * 表示是否审核结束。审核通过或者失败都会返回true，审核中返回false。
     */
    val isReviewed: Boolean,

    /**
     * 视频创建时间戳
     */
    val createTime: Long,

    /**
     * 视频id
     */
    val itemId: String,

    /**
     * 视频播放页面。视频播放页可能会失效，请在观看视频前调用/video/data/获取最新的播放页。
     */
    val shareUrl: String,

    /**
     * 表示视频状态。1:已发布;2:不适宜公开;4:审核中
     */
    val videoStatus: Int,

    /**
     * 视频标题
     */
    val title: String,

    /**
     * 是否置顶
     */
    val isTop: Boolean,

    /**
     * 统计数据
     */
    val statistics: Statistics,
)

