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
 * <p> 订单状态枚举 </p>
 * <p> create 2021-08-23 16:10 by lesible </p>
 * @author 何嘉豪
 */
@JsonSerialize(using = OrderStatusEnum.Serializer::class)
@JsonDeserialize(using = OrderStatusEnum.Deserializer::class)
enum class OrderStatusEnum(private val orderStatus: Int) {

    /**
     * 订单确认状态
     */
    ORDER_CONFIRMED(0),

    /**
     * 价格变动
     */
    PRICE_MODIFIED(1),

    /**
     * 库存不足
     */
    NO_ENOUGH_STOCK(2),

    /**
     * 订单确认中
     */
    ORDER_CONFIRMING(3);

    companion object {

        fun getEnumByInnerValue(orderStatus: Int?) = values().find { it.orderStatus == orderStatus }

    }

    class Serializer : StdSerializer<OrderStatusEnum>(OrderStatusEnum::class.java) {

        override fun serialize(value: OrderStatusEnum?, gen: JsonGenerator, provider: SerializerProvider?) {
            if (value != null) {
                gen.writeNumber(value.orderStatus)
            }
        }

    }

    class Deserializer : StdDeserializer<OrderStatusEnum?>(OrderStatusEnum::class.java) {

        override fun deserialize(p: JsonParser, ctx: DeserializationContext): OrderStatusEnum? {
            val node = p.codec.readTree<JsonNode>(p)
            val orderStatus = node.asInt()
            return getEnumByInnerValue(orderStatus)
        }

    }

}
