package com.sumwhy.bytedance.open.model.resp.enterprise

import com.sumwhy.bytedance.open.model.universal.enterprise.enumeration.BizToolStatusEnum
import com.sumwhy.bytedance.open.model.universal.enterprise.enumeration.BizToolTypeEnum

/**
 * 营销组件
 */
data class BizTool(

    /**
     * 工具类型
     */
    val toolType: BizToolTypeEnum,

    /**
     * 工具 id
     */
    val toolId: String,

    /**
     * 工具名称
     */
    val toolName: String,

    /**
     * 工具状态
     */
    val toolStatus: BizToolStatusEnum,
)
