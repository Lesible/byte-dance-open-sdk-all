package com.sumwhy.bytedance.open.model.resp.poi.order

import com.sumwhy.bytedance.open.model.resp.BaseData
import com.sumwhy.bytedance.open.model.universal.poi.order.enumeration.OrderStatusEnum

/**
 * <p> 订单支付通知结果 </p>
 * <p> create 2021-08-23 17:51 by lesible </p>
 * @author 何嘉豪
 */
data class OrderPayStatusNoticeResult(

    /**
     * 订单确认状态。0 - 订单确认,
     * 1 - 价格变动, 2 - 库存不足, 3 - 确认中
     */
    val status: OrderStatusEnum?,

    /**
     * 错误码
     */
    override val errorCode: Int,

    /**
     * 错误码描述
     */
    override val description: String,
) : BaseData(errorCode, description)