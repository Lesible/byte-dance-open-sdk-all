package com.sumwhy.bytedance.open.client

import com.sumwhy.bytedance.open.api.VideoApi
import com.sumwhy.bytedance.open.model.req.UniversalListParam
import com.sumwhy.bytedance.open.model.req.video.VideoDataReq
import com.sumwhy.bytedance.open.model.resp.ByteDanceResp
import com.sumwhy.bytedance.open.model.resp.video.ListVideoResult

class VideoClient(private val videoApi: VideoApi) {

    /**
     * 列出指定用户的视频
     *
     * @param universalListParam 通用列表查询参数
     * @return 用户视频列表
     */
    fun listVideo(universalListParam: UniversalListParam): ByteDanceResp<ListVideoResult>? {
        val listVideoQuery = videoApi.listVideo(universalListParam.toParamMap()).execute()
        return if (listVideoQuery.isSuccessful) listVideoQuery.body() else null
    }

    /**
     * 查询指定视频数据
     */
    fun videoData(openId: String, accessToken: String, videoDataReq: VideoDataReq): String? {
        val videoDataQuery = videoApi.videoData(openId, accessToken, videoDataReq).execute()
        return if (videoDataQuery.isSuccessful) videoDataQuery.body() else null
    }

}
