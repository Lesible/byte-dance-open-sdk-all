package com.sumwhy.bytedance.open.model.req.data

/**
 * <p>  </p>
 * <p> create 2021-08-06 09:40 by lesible </p>
 * @author 何嘉豪
 */
open class DataBaseParam(
    /**
     * openId 用户唯一标志
     */
    open val openId: String,

    /**
     * 请求凭证 此token需要用户授权
     */
    open val accessToken: String,

    /**
     * 近7/15天；输入7代表7天、15代表15天、30代表30天
     */
    open val dateType: Int,
) {
    open fun toParamMap() =
        mapOf(
            "open_id" to openId,
            "access_token" to accessToken,
            "date_type" to when {
                dateType <= 7 -> "7"
                dateType in 8..15 -> "15"
                else -> "30"
            }
        )
}
