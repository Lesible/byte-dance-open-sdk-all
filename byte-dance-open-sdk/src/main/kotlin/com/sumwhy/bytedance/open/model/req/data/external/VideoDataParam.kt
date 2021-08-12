package com.sumwhy.bytedance.open.model.req.data.external

import com.sumwhy.bytedance.open.model.req.data.DataBaseParam

/**
 * <p> 视频参数 </p>
 * <p> create 2021-08-11 11:29 by lesible </p>
 *
 * @author 何嘉豪
 */
data class VideoDataParam(
    /**
     * 近7/15天；输入7代表7天、15代表15天、30代表30天
     */
    val itemId: String,
    val dateType: Int? = null,
    override val openId: String,
    override val accessToken: String,
) : DataBaseParam(openId, accessToken) {
    fun toParamMap(): Map<String, String> {
        val map = mutableMapOf(
            "open_id" to openId,
            "access_token" to accessToken,
            "item_id" to itemId
        )
        if (dateType != null) {
            map["date_type"] = standardizationDateType(dateType)
        }
        return map.toMap()
    }
}