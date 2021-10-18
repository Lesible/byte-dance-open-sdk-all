package com.sumwhy.bytedance.open.model.universal.enterprise.enumeration

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
 * 绑定类型枚举值
 */
@JsonSerialize(using = BindTypeEnum.Serializer::class)
@JsonDeserialize(using = BindTypeEnum.Deserializer::class)
enum class BindTypeEnum(val bindType: Int) {

    /**
     * 取消绑定
     */
    UNBOUND(0),

    /**
     * 立即绑定
     */
    BOUND(1),

    /**
     * 预绑定(适用于工具在审核中，当工具审核通过后，会自动关联上)
     */
    PRE_BOUND(2);

    fun getValue() = this.bindType

    companion object {
        fun getEnumByInnerValue(bindType: Int?) =
            values().find { it.bindType == bindType }
    }

    class Serializer :
        StdSerializer<BindTypeEnum>(BindTypeEnum::class.java) {

        override fun serialize(value: BindTypeEnum?, gen: JsonGenerator, provider: SerializerProvider?) {
            if (value != null) {
                gen.writeNumber(value.bindType)
            }
        }

    }

    class Deserializer : StdDeserializer<BindTypeEnum>(BindTypeEnum::class.java) {

        override fun deserialize(p: JsonParser, ctx: DeserializationContext): BindTypeEnum? {
            val node = p.codec.readTree<JsonNode>(p)
            val bindType = node.asInt()
            return getEnumByInnerValue(bindType)
        }
    }

}