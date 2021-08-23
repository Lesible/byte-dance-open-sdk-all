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
 * 商铺类型枚举
 *
 * <p> create by lesible at 2021-8-21 16:48:35 </p>
 * @author 何嘉豪
 */
@JsonSerialize(using = SupplierTypeEnum.Serializer::class)
@JsonDeserialize(using = SupplierTypeEnum.Deserializer::class)
enum class SupplierTypeEnum(private val supplierType: Int) {

    /**
     * 酒店民宿
     */
    HOTEL(1),

    /**
     * 餐饮
     */
    FOOD(2),

    /**
     * 景区
     */
    SCENIC(3),

    /**
     * 电商
     */
    E_COMMERCE(4),

    /**
     * 教育
     */
    EDUCATION(5),

    /**
     * 丽人
     */
    BEAUTY(6),

    /**
     * 爱车
     */
    CAR(7),

    /**
     * 亲子
     */
    PATERNITY(8),

    /**
     * 宠物
     */
    PET(9),

    /**
     * 装修
     */
    DECORATION(10),

    /**
     * 娱乐场所
     */
    ENTERTAINMENT(11),

    /**
     * 图文打印
     */
    PRINT_SERVICE(12);

    companion object {

        fun getEnumByInnerValue(supplierType: Int?) = values().find { it.supplierType == supplierType }

    }

    class Serializer : StdSerializer<SupplierTypeEnum>(SupplierTypeEnum::class.java) {

        override fun serialize(value: SupplierTypeEnum?, gen: JsonGenerator, provider: SerializerProvider?) {
            if (value != null) {
                gen.writeNumber(value.supplierType)
            }
        }

    }

    class Deserializer : StdDeserializer<SupplierTypeEnum?>(SupplierTypeEnum::class.java) {

        override fun deserialize(p: JsonParser, ctx: DeserializationContext): SupplierTypeEnum? {
            val node = p.codec.readTree<JsonNode>(p)
            val supplierType = node.asInt()
            return getEnumByInnerValue(supplierType)
        }

    }
}
