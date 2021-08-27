package com.sumwhy.bytedance.open.model.req.poi.product

/**
 * <p> 达人分佣配置请求 </p>
 * <p> create 2021-08-27 10:53 by lesible </p>
 * @author 何嘉豪
 */
class SpuTakeRateSyncReq private constructor(builder: Builder) {

    /**
     * 接入方商品ID
     */
    val spuExtId = builder.spuExtId

    /**
     * 1-在线；
     */
    val status = builder.status

    /**
     * 分佣值，万分位。
     */
    val takeRate = builder.takeRate


    /**
     * 抖音号，抖音个人页可查询
     */
    val douyinId = builder.douyinId

    companion object {

        @JvmStatic
        fun builder(
            spuExtId: String,
            status: Int,
            takeRate: Int,
            douyinId: String,
        ) = Builder(spuExtId, status, takeRate, douyinId)

    }

    class Builder internal constructor(
        val spuExtId: String,
        val status: Int,
        val takeRate: Int,
        val douyinId: String,
    ) {
        fun build() = SpuTakeRateSyncReq(this)
    }

}