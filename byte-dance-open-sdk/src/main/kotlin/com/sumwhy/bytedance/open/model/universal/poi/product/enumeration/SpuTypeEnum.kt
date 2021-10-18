package com.sumwhy.bytedance.open.model.universal.poi.product.enumeration

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
 * SPU 类型枚举
 * <p> @date: 2021-08-21 18:04</p>
 * @author Lesible
 */
@JsonSerialize(using = SpuTypeEnum.Serializer::class)
@JsonDeserialize(using = SpuTypeEnum.Deserializer::class)
enum class SpuTypeEnum(private val spuType: Int) {

    /**
     * 日历房
     */
    CALENDAR_HOUSE(1),

    /**
     *  酒店预授权
     */
    HOTEL_PRESALE_COUPON(30),

    /**
     * 门票
     */
    TICKET(90),

    /**
     * 团购券
     */
    GROUPON_COUPON(91);

    fun getValue() = this.spuType

    companion object {

        fun getEnumByInnerValue(spuType: Int?) = values().find { it.spuType == spuType }

    }


    class Serializer : StdSerializer<SpuTypeEnum>(SpuTypeEnum::class.java) {

        override fun serialize(value: SpuTypeEnum?, gen: JsonGenerator, provider: SerializerProvider?) {
            if (value != null) {
                gen.writeNumber(value.spuType)
            }
        }

    }

    class Deserializer : StdDeserializer<SpuTypeEnum?>(SpuTypeEnum::class.java) {

        override fun deserialize(p: JsonParser, ctx: DeserializationContext): SpuTypeEnum? {
            val node = p.codec.readTree<JsonNode>(p)
            val spuType = node.asInt()
            return getEnumByInnerValue(spuType)
        }

    }

}