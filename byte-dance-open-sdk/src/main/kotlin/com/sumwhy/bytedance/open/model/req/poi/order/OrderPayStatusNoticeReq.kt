package com.sumwhy.bytedance.open.model.req.poi.order

/**
 * <p> 订单支付状态通知请求 </p>
 * <p> create 2021-08-23 17:19 by lesible </p>
 * @author 何嘉豪
 */
class OrderPayStatusNoticeReq(
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
     * 支付状态, 1 - 付款成功;
     */
    val status: Int,
)