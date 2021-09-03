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
 * 营销组件类型枚举值
 */
@JsonSerialize(using = BizToolTypeEnum.Serializer::class)
@JsonDeserialize(using = BizToolTypeEnum.Deserializer::class)
enum class BizToolTypeEnum(val bizToolType: Int) {

    /**
     * 在线预约落地页
     */
    ONLINE_RESERVE(1),

    /**
     * 线索收集落地页
     */
    CLUE_COLLECTOR(2),

    /**
     * 联系我们落地页
     */
    CONTACT_US(1),

    /**
     * 官网主页落地页
     */
    OFFICIAL_SITE(4),

    /**
     * 商品聚合落地页
     */
    MULTI_GROUPON(5),

    /**
     * 团购商品
     */
    GROUPON_GOOD(6),

    /**
     * 行业工具
     */
    INDUSTRY_TOOL(7);

    companion object {
        fun getEnumByInnerValue(bizToolType: Int?) =
            values().find { it.bizToolType == bizToolType }
    }

    class Serializer :
        StdSerializer<BizToolTypeEnum>(BizToolTypeEnum::class.java) {

        override fun serialize(value: BizToolTypeEnum?, gen: JsonGenerator, provider: SerializerProvider?) {
            if (value != null) {
                gen.writeNumber(value.bizToolType)
            }
        }

    }

    class Deserializer : StdDeserializer<BizToolTypeEnum>(BizToolTypeEnum::class.java) {

        override fun deserialize(p: JsonParser, ctx: DeserializationContext): BizToolTypeEnum? {
            val node = p.codec.readTree<JsonNode>(p)
            val bizToolType = node.asInt()
            return getEnumByInnerValue(bizToolType)
        }
    }

}