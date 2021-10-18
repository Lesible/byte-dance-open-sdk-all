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
 * 在线类型枚举
 *
 * <p> create by lesible at 2021-8-21 16:45:12 </p>
 * @author 何嘉豪
 */
@JsonSerialize(using = OnlineStatusEnum.Serializer::class)
@JsonDeserialize(using = OnlineStatusEnum.Deserializer::class)
enum class OnlineStatusEnum(private val onlineStatus: Int) {

    /**
     * 在线状态
     */
    ONLINE_STATUS(1),

    /**
     * 下线状态
     */
    OFFLINE_STATUS(2);

    fun getValue() = this.onlineStatus

    companion object {

        fun getEnumByInnerValue(onlineStatus: Int?) = values().find { it.onlineStatus == onlineStatus }

    }

    class Serializer : StdSerializer<OnlineStatusEnum>(OnlineStatusEnum::class.java) {

        override fun serialize(value: OnlineStatusEnum?, gen: JsonGenerator, provider: SerializerProvider?) {
            if (value != null) {
                gen.writeNumber(value.onlineStatus)
            }
        }

    }

    class Deserializer : StdDeserializer<OnlineStatusEnum?>(OnlineStatusEnum::class.java) {

        override fun deserialize(p: JsonParser, ctx: DeserializationContext): OnlineStatusEnum? {
            val node = p.codec.readTree<JsonNode>(p)
            val onlineStatus = node.asInt()
            return getEnumByInnerValue(onlineStatus)
        }

    }

}