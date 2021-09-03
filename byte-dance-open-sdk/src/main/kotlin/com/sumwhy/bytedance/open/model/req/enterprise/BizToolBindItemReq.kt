package com.sumwhy.bytedance.open.model.req.enterprise

import com.sumwhy.bytedance.open.model.universal.enterprise.enumeration.BindTypeEnum
import com.sumwhy.bytedance.open.model.universal.enterprise.enumeration.BizToolTypeEnum

/**
 * 绑定参数
 */
class BizToolBindItemReq private constructor(builder: Builder) {

    /**
     * 短视频id
     */
    val itemId = builder.itemId

    /**
     * 营销组件类型
     */
    val toolType = builder.toolType

    /**
     * 绑定类型
     */
    val bindType = builder.bindType

    /**
     * 营销组件 id
     */
    val toolId = builder.toolId

    companion object {

        @JvmStatic
        fun builder(
            itemId: String,
            toolType: BizToolTypeEnum,
            bindType: BindTypeEnum,
        ) = Builder(itemId, toolType, bindType)

    }

    class Builder internal constructor(
        val itemId: String,
        val toolType: BizToolTypeEnum,
        val bindType: BindTypeEnum,
    ) {

        var toolId: String? = null

        fun toolId(toolId: String): Builder {
            this.toolId = toolId
            return this
        }

        fun build() = BizToolBindItemReq(this)

    }

}
