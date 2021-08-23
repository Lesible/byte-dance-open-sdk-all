package com.sumwhy.bytedance.open.model.req.poi.order

/**
 * <p> 核销预授权请求 </p>
 * <p> create 2021-08-23 18:16 by lesible </p>
 * @author 何嘉豪
 */
class PreSaleCouponConfirmReq(

    /**
     * 抖音用户唯一标识
     */
    val openId: String,

    /**
     * 接入方订单 id
     */
    val orderExtId: String,

    /**
     * 接入方券码 id
     */
    val codeList: List<String>,
)