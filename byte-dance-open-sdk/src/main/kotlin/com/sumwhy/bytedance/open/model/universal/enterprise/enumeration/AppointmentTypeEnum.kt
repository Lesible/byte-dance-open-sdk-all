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

@JsonSerialize(using = AppointmentTypeEnum.Serializer::class)
@JsonDeserialize(using = AppointmentTypeEnum.Deserializer::class)
enum class AppointmentTypeEnum(val appointmentType: Int) {

    /**
     * 未知
     */
    APPOINTMENT_TYPE_UNKNOWN(0),

    /**
     * 私信互动->预约
     */
    APPOINTMENT_TYPE_IM_RESERVED(1),

    /**
     * 企业主页互动->预约
     */
    APPOINTMENT_TYPE_PROFILES_RESERVED(2),

    /**
     * 直播->预约
     */
    APPOINTMENT_TYPE_LIVE_RESERVED(3),

    /**
     * 短视频->预约
     */
    APPOINTMENT_TYPE_VIDEO_RESERVED(4),

    /**
     * 行业工具->预约
     */
    APPOINTMENT_TYPE_INDUSTRY_COMPONENT_RESERVED(5);


    companion object {
        fun getEnumByInnerValue(appointmentType: Int?) =
            values()
                .find { it.appointmentType == appointmentType }
    }

    class Serializer :
        StdSerializer<AppointmentTypeEnum>(AppointmentTypeEnum::class.java) {

        override fun serialize(value: AppointmentTypeEnum?, gen: JsonGenerator, provider: SerializerProvider?) {
            if (value != null) {
                gen.writeNumber(value.appointmentType)
            }
        }

    }

    class Deserializer : StdDeserializer<AppointmentTypeEnum>(AppointmentTypeEnum::class.java) {

        override fun deserialize(p: JsonParser, ctx: DeserializationContext): AppointmentTypeEnum? {
            val node = p.codec.readTree<JsonNode>(p)
            val appointmentType = node.asInt()
            return getEnumByInnerValue(appointmentType)
        }
    }

}