package com.sumwhy.bytedance.open.model.resp.poi.order

import com.sumwhy.bytedance.open.model.resp.BaseData

/**
 * <p> 取消订单结果 </p>
 * <p> create 2021-08-23 18:08 by lesible </p>
 * @author 何嘉豪
 */
data class OrderCancelResult(

    /**
     * 取消订单确认状态码；0 - 接受取消
     */
    val status: Int?,

    /**
     * 错误码
     */
    override val errorCode: Int,

    /**
     * 错误码描述
     */
    override val description: String,
) : BaseData(errorCode, description)