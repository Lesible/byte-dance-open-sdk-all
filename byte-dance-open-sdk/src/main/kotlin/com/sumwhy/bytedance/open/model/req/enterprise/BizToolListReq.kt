package com.sumwhy.bytedance.open.model.req.enterprise

import com.sumwhy.bytedance.open.model.universal.enterprise.enumeration.BizToolTypeEnum

/**
 * <p>  </p>
 * <p> create 2021-09-02 18:34 by lesible </p>
 * @author 何嘉豪
 */
class BizToolListReq(
    /**
     * 请求凭证
     */
    private val accessToken: String,

    /**
     * 用户唯一标识
     */
    private val openId: String,

    /**
     * 当前页码 从 0 开始
     */
    private val page: Int,

    /**
     * 每页大小
     */
    private val pageSize: Int,

    /**
     * 营销工具类型
     */
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