package com.sumwhy.bytedance.open.model.req.enterprise

import com.sumwhy.bytedance.open.model.universal.enterprise.enumeration.BizToolTypeEnum

/**
 * <p>  </p>
 * <p> create 2021-09-02 18:34 by lesible </p>
 * @author 何嘉豪
 */
class BizToolListReq(
    private val accessToken: String,
    private val openId: String,
    private val page: Int,
    private val pageSize: Int,
    private val toolType: BizToolTypeEnum,
) {
    fun toParamMap() = mapOf(
        "access_token" to accessToken,
        "open_id" to openId,
        "page" to page.toString(),
        "page_size" to pageSize.toString(),
        "tool_type" to toolType.bizToolType.toString()
    )

}