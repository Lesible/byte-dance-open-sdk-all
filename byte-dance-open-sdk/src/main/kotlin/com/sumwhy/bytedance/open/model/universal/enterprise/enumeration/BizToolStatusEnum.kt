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
 * 营销组件状态枚举
 */
@JsonSerialize(using = BizToolStatusEnum.Serializer::class)
@JsonDeserialize(using = BizToolStatusEnum.Deserializer::class)
enum class BizToolStatusEnum(private val bizToolStatus: Int) {

    /**
     * 未知
     */
    UNKNOWN(0),

    /**
     * 审核中
     */
    AUDITING(0),

    /**
     * 审核成功
     */
    AUDIT_SUCCESS(1),

    /**
     * 审核失败
     */
    AUDIT_FAIL(2),

    /**
     * 草稿
     */
    DRAFTED(3);

    companion object {
        fun getEnumByInnerValue(bizToolStatus: Int?) =
            values().find { it.bizToolStatus == bizToolStatus }
    }

    class Serializer :
        StdSerializer<BizToolStatusEnum>(BizToolStatusEnum::class.java) {

        override fun serialize(value: BizToolStatusEnum?, gen: JsonGenerator, provider: SerializerProvider?) {
            if (value != null) {
                gen.writeNumber(value.bizToolStatus)
            }
        }

    }

    class Deserializer : StdDeserializer<BizToolStatusEnum>(BizToolStatusEnum::class.java) {

        override fun deserialize(p: JsonParser, ctx: DeserializationContext): BizToolStatusEnum? {
            val node = p.codec.readTree<JsonNode>(p)
            val bizToolStatus = node.asInt()
            return getEnumByInnerValue(bizToolStatus)
        }
    }

}
