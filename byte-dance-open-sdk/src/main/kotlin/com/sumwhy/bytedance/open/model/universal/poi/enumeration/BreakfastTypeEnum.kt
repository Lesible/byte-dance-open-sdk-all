package com.sumwhy.bytedance.open.model.universal.poi.enumeration

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
 * <p> 早餐类型 </p>
 * <p> create by lesible at 2021-08-21 22:31</p>
 * @author 何嘉豪
 */
@JsonSerialize(using = BreakfastTypeEnum.Serializer::class)
@JsonDeserialize(using = BreakfastTypeEnum.Deserializer::class)
enum class BreakfastTypeEnum(private val breakfastType: Int) {

    /**
     * 无早餐
     */
    NO_BREAKFAST(0),

    /**
     * 普通早餐
     */
    NORMAL_BREAKFAST(1),

    /**
     * 自助餐
     */
    BUFFET(2);

    fun getValue() = this.breakfastType

    companion object {
        fun getEnumByInnerValue(breakfastType: Int?) = values().find { it.breakfastType == breakfastType }
    }

    class Serializer : StdSerializer<BreakfastTypeEnum>(BreakfastTypeEnum::class.java) {

        override fun serialize(value: BreakfastTypeEnum?, gen: JsonGenerator, provider: SerializerProvider?) {
            if (value != null) {
                gen.writeNumber(value.breakfastType)
            }
        }

    }

    class Deserializer : StdDeserializer<BreakfastTypeEnum>(BreakfastTypeEnum::class.java) {

        override fun deserialize(p: JsonParser, ctx: DeserializationContext): BreakfastTypeEnum? {
            val node = p.codec.readTree<JsonNode>(p)
            val breakfastType = node.asInt()
            return getEnumByInnerValue(breakfastType)
        }
    }

}