package com.sumwhy.bytedance.open.client

import com.sumwhy.bytedance.open.api.DataApi
import com.sumwhy.bytedance.open.model.req.data.external.VideoDataParam
import com.sumwhy.bytedance.open.model.resp.ByteDanceResp
import com.sumwhy.bytedance.open.model.resp.data.BaseDataResult
import com.sumwhy.bytedance.open.model.resp.data.video.*

/**
 * <p> 数据开放服务 - 用户数据 - 视频数据 </p>
 * <p> create 2021-08-11 11:46 by lesible </p>
 * @author 何嘉豪
 */
class DataVideoClient(private val dataApi: DataApi) {

    /**
     * 获取指定视频的基本信息
     *
     * @param videoDataParam 视频数据查询参数
     * @return 指定视频的基本信息
     */
    fun getItemBase(videoDataParam: VideoDataParam): ByteDanceResp<VideoBaseResult>? {
        val videoItemBase = dataApi.getItemBase(videoDataParam.toParamMap()).execute()
        return if (videoItemBase.isSuccessful) videoItemBase.body() else null
    }

    /**
     * 获取指定视频的点赞数据
     *
     * @param videoDataParam 视频数据查询参数
     * @return 指定视频的点赞数据
     */
    fun getItemLike(videoDataParam: VideoDataParam): ByteDanceResp<BaseDataResult<VideoLike>>? {
        val videoItemLike = dataApi.getItemLike(videoDataParam.toParamMap()).execute()
        return if (videoItemLike.isSuccessful) videoItemLike.body() else null
    }

    /**
     * 获取指定视频的评论数据
     *
     * @param videoDataParam 视频数据查询参数
     * @return 指定视频的评论数据
     */
    fun getItemComment(videoDataParam: VideoDataParam): ByteDanceResp<BaseDataResult<VideoComment>>? {
        val videoItemComment = dataApi.getItemComment(videoDataParam.toParamMap()).execute()
        return if (videoItemComment.isSuccessful) videoItemComment.body() else null
    }

    /**
     * 获取指定视频的播放数据
     *
     * @param videoDataParam 视频数据查询参数
     * @return 指定视频的播放数据
     */
    fun getItemPlay(videoDataParam: VideoDataParam): ByteDanceResp<BaseDataResult<VideoPlay>>? {
        val videoItemPlay = dataApi.getItemPlay(videoDataParam.toParamMap()).execute()
        return if (videoItemPlay.isSuccessful) videoItemPlay.body() else null
    }

    /**
     * 获取指定视频的分享数据
     *
     * @param videoDataParam 视频数据查询参数
     * @return 指定视频的分享数据
     */
    fun getItemShare(videoDataParam: VideoDataParam): ByteDanceResp<BaseDataResult<VideoShare>>? {
        val videoItemShare = dataApi.getItemShare(videoDataParam.toParamMap()).execute()
        return if (videoItemShare.isSuccessful) videoItemShare.body() else null
    }

}