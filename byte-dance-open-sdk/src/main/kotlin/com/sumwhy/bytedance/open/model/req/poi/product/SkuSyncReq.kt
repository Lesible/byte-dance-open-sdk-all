package com.sumwhy.bytedance.open.model.req.poi.product

import com.fasterxml.jackson.annotation.JsonProperty
import com.sumwhy.bytedance.open.model.universal.poi.enumeration.OnlineStatusEnum

/**
 * <p> 同步 sku 请求 </p>
 * <p> create 2021-08-23 14:51 by lesible </p>
 * @author 何嘉豪
 */
data class SkuSyncReq(

    /**
     * 同步 sku 列表
     */
    val skus: List<SyncingSku>,

    /**
     * 外部平台 spu id
     */
    val spuExtId: String,
)

class SyncingSku private constructor(builder: Builder) {

    /**
     * sku 属性字段
     */
    val attributes: SkuAttributes? = builder.attributes

    /**
     * 价格 (人民币分)
     */
    val price: Long? = builder.price

    /**
     * 在线状态
     */
    val status: OnlineStatusEnum? = builder.status

    /**
     * 库存数量
     */
    val stock: Long? = builder.stock

    companion object {

        @JvmStatic
        fun builder() = Builder()

    }

    class Builder {
        var attributes: SkuAttributes? = null
        var price: Long? = null
        var status: OnlineStatusEnum? = null
        var stock: Long? = null

        fun attributes(attributes: SkuAttributes): Builder {
            this.attributes = attributes
            return this
        }

        fun price(price: Long): Builder {
            this.price = price
            return this
        }

        fun status(status: OnlineStatusEnum): Builder {
            this.status = status
            return this
        }

        fun stock(stock: Long): Builder {
            this.stock = stock
            return this
        }

        fun build() = SyncingSku(this)

    }

}

data class SkuAttributes(
    /**
     * 酒店民宿 sku 日期
     */
    @JsonProperty("1301")
    val skuDate: String,
)