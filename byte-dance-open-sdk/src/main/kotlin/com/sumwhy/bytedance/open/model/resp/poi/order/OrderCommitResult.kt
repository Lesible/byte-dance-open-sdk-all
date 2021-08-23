package com.sumwhy.bytedance.open.model.resp.poi.order

import com.sumwhy.bytedance.open.model.resp.BaseData

/**
 * <p> 下单结果 </p>
 * <p> create 2021-08-23 16:32 by lesible </p>
 * @author 何嘉豪
 */
data class OrderCommitResult(

    /**
     * 外部订单id
     */
    val orderExtId: String?,

    /**
     * 错误码
     */
    override val errorCode: Int,

    /**
     * 错误码描述
     */
    override val description: String,
) : BaseData(errorCode, description)