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
 * 富文本节点类型枚举
 *
 * <p> create by lesible at 2021-8-21 16:45:12 </p>
 * @author 何嘉豪
 */
@JsonSerialize(using = NodeTypeEnum.NodeTypeEnumSerializer::class)
@JsonDeserialize(using = NodeTypeEnum.NodeTypeEnumDeserializer::class)
enum class NodeTypeEnum(private val nodeType: Int) {

    /**
     * 文本
     */
    TEXT(1),

    /**
     * 图片
     */
    IMAGE(2);

    companion object {

        fun getEnumByInnerValue(nodeType: Int?) = values().find { it.nodeType == nodeType }

    }

    class NodeTypeEnumDeserializer :
        StdDeserializer<NodeTypeEnum?>(NodeTypeEnum::class.java) {

        override fun deserialize(p: JsonParser, ctx: DeserializationContext): NodeTypeEnum? {
            val node = p.codec.readTree<JsonNode>(p)
            val nodeType = node.asInt()
            return getEnumByInnerValue(nodeType)
        }
    }

    class NodeTypeEnumSerializer :
        StdSerializer<NodeTypeEnum>(NodeTypeEnum::class.java) {
        override fun serialize(value: NodeTypeEnum?, gen: JsonGenerator, provider: SerializerProvider?) {
            if (value != null) {
                gen.writeNumber(value.nodeType)
            }
        }

    }
}
