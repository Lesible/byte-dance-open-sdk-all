package com.sumwhy.bytedance.open.client

import com.sumwhy.bytedance.open.api.VideoApi
import com.sumwhy.bytedance.open.model.req.video.ListVideoParam
import com.sumwhy.bytedance.open.model.resp.ByteDanceResp
import com.sumwhy.bytedance.open.model.resp.video.ListVideoResult

class VideoClient(private val videoApi: VideoApi) {


    fun listVideo(listVideoParam: ListVideoParam): ByteDanceResp<ListVideoResult>? {
        val listVideoQuery = videoApi.listVideo(listVideoParam.toParamMap())
        return listVideoQuery.execute().body()
    }

}
