package com.sumwhy.bytedance.open.model.req.poi.order

import com.sumwhy.bytedance.open.model.universal.poi.order.enumeration.OrderStatusEnum

/**
 * <p> 订单状态同步请求 </p>
 * <p> create 2021-08-23 16:10 by lesible </p>
 * @author 何嘉豪
 */
class OrderStatusSyncReq(

    /**
     * 接入方订单号
     */
    val orderExtId: String,

    /**
     * 抖音订单号
     */
    val orderId: String,

    /**
     * 订单确认状态。0 - 订单确认, 1 - 价格变动, 2 - 库存不足, 3 - 确认中
     */
    val status: OrderStatusEnum,

    /**
     * 接入方商铺ID
     */
    val supplierExtId: String,
)