package com.sumwhy.bytedance.open.client

import com.sumwhy.bytedance.open.api.DataApi
import com.sumwhy.bytedance.open.model.req.data.external.VideoDataParam

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
     */
    fun getItemBase(videoDataParam: VideoDataParam): String? {
        val videoItemBase = dataApi.getItemBase(videoDataParam.toParamMap()).execute()
        return if (videoItemBase.isSuccessful) videoItemBase.body() else null
    }

    /**
     * 获取指定视频的播放数据
     *
     * @param videoDataParam 视频数据查询参数
     */
    fun getItemPlay(videoDataParam: VideoDataParam): String? {
        val videoItemPlay = dataApi.getItemPlay(videoDataParam.toParamMap()).execute()
        return if (videoItemPlay.isSuccessful) videoItemPlay.body() else null
    }

}