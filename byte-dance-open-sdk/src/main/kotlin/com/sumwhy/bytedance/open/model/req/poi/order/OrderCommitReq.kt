package com.sumwhy.bytedance.open.model.req.poi.order

/**
 * <p> 下单请求 </p>
 * <p> create 2021-08-23 16:36 by lesible </p>
 * @author 何嘉豪
 */
class OrderCommitReq private constructor(builder: Builder) {

    /**
     * 预订人电话
     */
    val customerPhone = builder.customerPhone

    /**
     * 预定数量
     */
    val reserveAmount = builder.reserveAmount

    /**
     * 接入方房型 id
     */
    val spuExtId = builder.spuExtId

    /**
     * 订单支付状态。0 - 未支付, 1 - 已支付
     */
    val status = builder.status

    /**
     * 总价 (单位分)
     */
    val totalPrice = builder.totalPrice

    /**
     * 入住时间 yyyyMMdd
     */
    val checkIn = builder.checkIn

    /**
     * 离店时间 yyyyMMdd
     */
    val checkOut = builder.checkOut

    /**
     * 抖音订单号
     */
    val orderId = builder.orderId

    /**
     * 预订人姓名
     */
    val customerName = builder.customerName

    /**
     * 入住日价格列表
     */
    val datePrice = builder.datePrice

    /**
     * 备注
     */
    val remark = builder.remark

    /**
     * 入住人列表
     */
    val customerList = builder.customerList

    companion object {

        @JvmStatic
        fun builder(
            customerPhone: String,
            reserveAmount: Int,
            spuExtId: String,
            status: Int,
            totalPrice: Long,
            checkIn: String,
            checkOut: String,
            orderId: String,
            customerName: String,
        ) = Builder(
            customerPhone,
            reserveAmount,
            spuExtId,
            status,
            totalPrice,
            checkIn,
            checkOut,
            orderId,
            customerName)

    }

    class Builder(
        val customerPhone: String,
        val reserveAmount: Int,
        val spuExtId: String,
        val status: Int,
        val totalPrice: Long,
        val checkIn: String,
        val checkOut: String,
        val orderId: String,
        val customerName: String,
    ) {
        var datePrice: List<DatePrice>? = null
        var remark: String? = null
        var customerList: List<CustomerName>? = null

        fun datePrice(datePrice: List<DatePrice>): Builder {
            this.datePrice = datePrice
            return this
        }

        fun remark(remark: String): Builder {
            this.remark = remark
            return this
        }

        fun customerList(customerList: List<CustomerName>): Builder {
            this.customerList = customerList
            return this
        }

        fun build() = OrderCommitReq(this)

    }

}

/**
 * <p> 入住日价格 </p>
 * <p> create 2021-08-23 16:49 by lesible </p>
 * @author 何嘉豪
 */
class DatePrice(

    /**
     * 入住日价格, 人民币分
     */
    val datePrice: Long,

    /**
     * 入住日期 yyyyMMdd
     */
    val date: String,
)

class CustomerName private constructor(builder: Builder) {

    val cnName = builder.cnName

    val givenName = builder.givenName

    val surname = builder.surname

    companion object {

        @JvmStatic
        fun builder() = Builder()

    }

    class Builder {

        var cnName: String? = null

        var givenName: String? = null

        var surname: String? = null

        fun cnName(cnName: String): Builder {
            this.cnName = cnName
            return this
        }

        fun givenName(givenName: String): Builder {
            this.givenName = givenName
            return this
        }

        fun surname(surname: String): Builder {
            this.surname = surname
            return this
        }

        fun build() = CustomerName(this)

    }

}