package com.sumwhy.bytedance.open.model.resp.data.video

import com.sumwhy.bytedance.open.model.resp.BaseData

/**
 * 视频基本指标信息
 */
data class VideoBaseResult(

    /**
     * 指标数据结果
     */
    val result: VideoBaseInfo?,

    /**
     *
     * 错误码描述
     */
    override val description: String,

    /**
     * 错误码
     */
    override val errorCode: Int,
) : BaseData(errorCode, description)

data class VideoBaseInfo(

    /**
     * 最近30天分享数
     */
    val totalShare: Int,

    /**
     * 最近30天平均播放时长
     */
    val avgPlayDuration: Int,

    /**
     * 最近30天评论数
     */
    val totalComment: Int,

    /**
     * 最近30天点赞数
     */
    val totalLike: Int,

    /**
     * 最近30天播放次数
     */
    val totalPlay: Int,
)
