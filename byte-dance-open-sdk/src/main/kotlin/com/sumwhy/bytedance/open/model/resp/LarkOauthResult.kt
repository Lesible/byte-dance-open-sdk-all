package com.sumwhy.bytedance.open.model.resp

data class LarkOauthResult(
    val accessToken: String?,
    val data: BaseData,
    val openId: String?,
    val extra: ExtraInfo?,
)
