package com.sumwhy.bytedance.open.model.resp.enterprise

/**
 * 绑定结果列表
 */
data class ItemBindBizToolListResult(

    /**
     * 绑定信息列表
     */
    val itemBindList: List<ItemBindInfo?>? = null,
)

/**
 * 短视频绑定信息
 */
data class ItemBindInfo(

    /**
     * 短视频 id
     */
    val itemId: String? = null,
    /**
     *  是否绑定
     */
    val isBind: Boolean,

    /**
     * 营销组件信息
     */
    val toolInfo: BizTool,
)

