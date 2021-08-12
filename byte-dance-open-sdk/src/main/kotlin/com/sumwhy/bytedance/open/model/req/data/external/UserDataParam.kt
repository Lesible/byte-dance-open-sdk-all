package com.sumwhy.bytedance.open.model.req.data.external

import com.sumwhy.bytedance.open.model.req.data.DataBaseParam

/**
 * <p>  </p>
 * <p> create 2021-08-11 11:23 by lesible </p>
 * @author 何嘉豪
 */
data class UserDataParam(
    /**
     * 近7/15天；输入7代表7天、15代表15天、30代表30天
     */
    val dateType: Int,
    override val openId: String,
    override val accessToken: String,
) : DataBaseParam(openId, accessToken) {
    fun toParamMap() =
        mapOf(
            "open_id" to openId,
            "access_token" to accessToken,
            "date_type" to standardizationDateType(dateType)
        )
}