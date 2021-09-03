package com.sumwhy.bytedance.open.model.resp.enterprise

/**
 * 营销组件列表
 */
data class BizToolListResult(

    /**
     * 总个数
     */
    val totalCount: Int?,

    /**
     * 总页数
     */
    val totalPage: Int?,

    /**
     * 营销组件列表
     */
    val componentList: List<BizTool>?,
)