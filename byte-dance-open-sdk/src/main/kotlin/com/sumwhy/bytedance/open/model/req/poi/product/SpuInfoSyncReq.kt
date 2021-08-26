package com.sumwhy.bytedance.open.model.req.poi.product

/**
 * <p> 同步 sku 信息请求 </p>
 * <p> create 2021-08-26 18:15 by lesible </p>
 * @author 何嘉豪
 */
class SpuInfoSyncReq private constructor(builder: Builder) {

    /**
     * 调用/oauth/client_token/生成的token，此token不需要用户授权。
     */
    val accessToken = builder.accessToken

    /**
     * 第三方SPU
     */
    val spuExtId = builder.spuExtId

    /**
     * 是否需要商品草稿数据(带有商品的审核状态，只展示最近30天的数据，并且最多最近提交的20次内)
     */
    val needSpuDraft = builder.needSpuDraft

    /**
     * 需要商品草稿数据的数目(0-20)，超过这个范围默认返回20个
     */
    val spuDraftCount = builder.spuDraftCount

    /**
     * 供应商id列表，需要商品在某供应商下的过滤状态
     */
    val supplierIdsForFilterReason = builder.supplierIdsForFilterReason

    companion object {

        @JvmStatic
        fun builder(
            accessToken: String,
            spuExtId: String,
            needSpuDraft: Boolean,
        ) = Builder(accessToken, spuExtId, needSpuDraft)

    }

    class Builder(
        val accessToken: String,
        val spuExtId: String,
        val needSpuDraft: Boolean,
    ) {
        var spuDraftCount: Int? = null
        var supplierIdsForFilterReason: List<String>? = null

        fun spuDraftCount(spuDraftCount: Int): Builder {
            this.spuDraftCount = spuDraftCount
            return this
        }

        fun supplierIdsForFilterReason(supplierIdsForFilterReason: List<String>): Builder {
            this.supplierIdsForFilterReason = supplierIdsForFilterReason
            return this
        }

        fun build() = SpuInfoSyncReq(this)

    }

}
