package com.sumwhy.bytedance.open.model.universal.poi.supplier.enumeration

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
 * 下单模板类型枚举
 *
 * <p> create by lesible at 2021-8-21 16:41:13 </p>
 * @author 何嘉豪
 */
@JsonSerialize(using = OrderTemplateEnum.Serializer::class)
@JsonDeserialize(using = OrderTemplateEnum.Deserializer::class)
enum class OrderTemplateEnum(private val orderTemplateType: Int) {

    /**
     * 国内模板
     */
    DOMESTIC_TEMPLATE(1),

    /**
     * 海外模板
     */
    ABOARD_TEMPLATE(2);

    fun getValue() = this.orderTemplateType

    companion object {

        fun getEnumByInnerValue(orderTemplateType: Int?) = values().find { it.orderTemplateType == orderTemplateType }

    }

    class Serializer : StdSerializer<OrderTemplateEnum>(OrderTemplateEnum::class.java) {

        override fun serialize(value: OrderTemplateEnum?, gen: JsonGenerator, provider: SerializerProvider?) {
            if (value != null) {
                gen.writeNumber(value.orderTemplateType)
            }
        }

    }

    class Deserializer : StdDeserializer<OrderTemplateEnum?>(OrderTemplateEnum::class.java) {

        override fun deserialize(p: JsonParser, ctx: DeserializationContext): OrderTemplateEnum? {
            val node = p.codec.readTree<JsonNode>(p)
            val orderTemplateType = node.asInt()
            return getEnumByInnerValue(orderTemplateType)
        }

    }

}
