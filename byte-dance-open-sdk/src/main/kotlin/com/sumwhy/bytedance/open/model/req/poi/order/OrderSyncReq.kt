package com.sumwhy.bytedance.open.model.req.poi.order

import com.sumwhy.bytedance.open.model.universal.poi.order.enumeration.OrderTypeEnum

/**
 * <p> 同步订单请求 </p>
 * <p> create 2021-08-26 09:31 by lesible </p>
 *
 * @author 何嘉豪
 */
class OrderSyncReq private constructor(builder: Builder) {

    /**
     * 发送请求的时间，精确到毫秒
     */
    val dateTime = builder.dateTime

    /**
     * 外部商家信息
     */
    val extShopInfo = builder.extShopInfo

    /**
     * 小程序形式对接抖音时，该字段必传
     */
    val miniApp = builder.miniApp

    /**
     * 订单的细节，不同的订单业务有不同的结构体，请具体询问业务方字段结构
     */
    val orderDetail = builder.orderDetail

    /**
     * 订单类型- 201 预约点餐订单, 202 餐厅预定订单,
     * 203 餐厅排队订单, 9001 景区门票订单, 9101 团购券订单,
     * 9201 在线预约订单, 9301 外卖订单, 140 住宿订单, 200 预售券订单
     */
    val orderType = builder.orderType

    companion object {

        @JvmStatic
        fun builder(dateTime: Long, extShopInfo: ExtShopInfo, orderDetail: String, orderType: OrderTypeEnum) =
            Builder(dateTime, extShopInfo, orderDetail, orderType)

    }

    class Builder internal constructor(
        val dateTime: Long,
        val extShopInfo: ExtShopInfo,
        val orderDetail: String,
        val orderType: OrderTypeEnum,
    ) {

        var miniApp: MiniApp? = null

        fun miniApp(miniApp: MiniApp): Builder {
            this.miniApp = miniApp
            return this
        }

        fun build() = OrderSyncReq(this)

    }


    /**
     * 外部商家信息
     *
     * @author 何嘉豪
     */
    class ExtShopInfo(

        /**
         * 外部商户 id
         */
        val extShopId: String,

        /**
         * 抖音商户 id
         */
        val shopId: String,
    )

    /**
     * 小程序形式对接抖音时，该字段必传
     *
     * @author 何嘉豪
     */
    class MiniApp(
        /**
         * 小程序 appId
         */
        val appId: String,

        /**
         * 小程序用户 openId
         */
        val userOpenId: String,
    )

}
