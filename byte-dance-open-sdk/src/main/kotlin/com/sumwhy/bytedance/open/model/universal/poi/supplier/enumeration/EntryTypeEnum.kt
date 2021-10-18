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
 * 入口类型枚举
 *
 * <p> create by lesible at 2021-8-21 16:45:12 </p>
 * @author 何嘉豪
 */
@JsonSerialize(using = EntryTypeEnum.Serializer::class)
@JsonDeserialize(using = EntryTypeEnum.Deserializer::class)
enum class EntryTypeEnum(private val entryType: Int) {

    /**
     * H5
     */
    H5(1),

    /**
     * 小程序
     */
    MINI_APP(2);

    fun getValue() = this.entryType

    companion object {

        fun getEnumByInnerValue(entryType: Int?) = values().find { it.entryType == entryType }

    }

    class Serializer : StdSerializer<EntryTypeEnum>(EntryTypeEnum::class.java) {

        override fun serialize(value: EntryTypeEnum?, gen: JsonGenerator, provider: SerializerProvider?) {
            if (value != null) {
                gen.writeNumber(value.entryType)
            }
        }

    }

    class Deserializer : StdDeserializer<EntryTypeEnum?>(EntryTypeEnum::class.java) {

        override fun deserialize(p: JsonParser, ctx: DeserializationContext): EntryTypeEnum? {
            val node = p.codec.readTree<JsonNode>(p)
            val entryType = node.asInt()
            return getEnumByInnerValue(entryType)
        }

    }

}
