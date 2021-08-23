package com.sumwhy.bytedance.open.model.req.poi.order

/**
 * <p> 取消订单请求 </p>
 * <p> create 2021-08-23 18:08 by lesible </p>
 * @author 何嘉豪
 */
class OrderCancelReq(
    /**
     * 接入方商铺ID
     */
    val supplierExtId: String,

    /**
     * 接入方订单号
     */
    val orderExtId: String,

    /**
     * 抖音订单号
     */
    val orderId: String,

    /**
     * 订单状态。0 - 未支付, 1 - 已支付
     */
    val orderStatus: Int,
)
