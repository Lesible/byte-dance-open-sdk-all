package com.sumwhy.bytedance.open.model.resp.poi.order

import com.sumwhy.bytedance.open.model.resp.BaseData

/**
 * <p> 订单同步结果 </p>
 * <p> create 2021-08-26 10:08 by lesible </p>
 * @author 何嘉豪
 */
data class OrderSyncResult(

    /**
     * 抖音平台订单ID
     */
    val orderId: String?,

    /**
     * 错误码
     */
    override val errorCode: Int,

    /**
     * 错误码描述
     */
    override val description: String,
) : BaseData(errorCode, description)