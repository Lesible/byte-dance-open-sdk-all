package com.sumwhy.bytedance.open.model.universal.poi.order.enumeration

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.databind.deser.std.StdDeserializer
import com.fasterxml.jackson.databind.ser.std.StdSerializer

/**
 *
 * 提供服务类型
 * <p> @date: 2021-08-21 18:04</p>
 * @author Lesible
 */
@JsonSerialize(using = OrderTypeEnum.Serializer::class)
@JsonDeserialize(using = OrderTypeEnum.Deserializer::class)
enum class OrderTypeEnum(private val orderType: Int) {

    /**
     * 预约点餐服务
     */
    APPOINT_ORDER_DISHES(201),

    /**
     * 预约订位服务
     */
    APPOINT_ORDER_SEAT(202),

    /**
     * 排队取号服务
     */
    QUEUE_FOR_TAKE_NUMBERS(203),

    /**
     * 门票预定服务
     */
    BOOKING_TICKET(204),

    /**
     * 团购套餐服务
     */
    GROUPING_BUYING_PACKAGE(9101),

    /**
     * 领优惠券服务
     */
    APPLY_COUPON(9102),

    /**
     * 在线预约服务
     */
    APPOINT_ONLINE(9201),

    /**
     * 外卖服务
     */
    TAKE_AWAY(9301),

    /**
     * 住宿服务
     */
    ACCOMMODATION(140),

    /**
     * 预约券服务
     */
    APPOINT_COUPON(200);

    companion object {

        fun getEnumByInnerValue(orderType: Int?) = values().find { it.orderType == orderType }

    }


    class Serializer : StdSerializer<OrderTypeEnum>(OrderTypeEnum::class.java) {

        override fun serialize(value: OrderTypeEnum?, gen: JsonGenerator, provider: SerializerProvider?) {
            if (value != null) {
                gen.writeNumber(value.orderType)
            }
        }

    }

    class Deserializer : StdDeserializer<OrderTypeEnum?>(OrderTypeEnum::class.java) {

        override fun deserialize(p: JsonParser, ctx: DeserializationContext): OrderTypeEnum? {
            val node = p.codec.readTree<JsonNode>(p)
            val orderType = node.asInt()
            return getEnumByInnerValue(orderType)
        }

    }

}