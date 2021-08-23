package com.sumwhy.bytedance.open.model.resp.poi.order

import com.sumwhy.bytedance.open.model.resp.BaseData

/**
 * <p> 核销预授权结果 </p>
 * <p> create 2021-08-23 18:16 by lesible </p>
 * @author 何嘉豪
 */
data class PreSaleCouponConfirmResult(

    /**
     * 接入方订单 id
     */
    val orderExtId: String?,


    /**
     * 接入方券码 id
     */
    val codeList: List<String>?,

    /**
     * 错误码
     */
    override val errorCode: Int,

    /**
     * 错误码描述
     */
    override val description: String,
) : BaseData(errorCode, description)