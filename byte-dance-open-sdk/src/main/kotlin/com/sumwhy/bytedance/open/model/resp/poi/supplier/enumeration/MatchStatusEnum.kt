package com.sumwhy.bytedance.open.model.resp.poi.supplier.enumeration

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.deser.std.StdDeserializer

/**
 * <p> 匹配状态枚举 </p>
 * <p> create 2021-08-23 11:46 by lesible </p>
 * @author 何嘉豪
 */
@JsonDeserialize(using = MatchStatusEnum.MatchStatusEnumDeserializer::class)
enum class MatchStatusEnum(private val matchTaskStatus: Int) {

    /**
     * 等待匹配
     */
    WAITING_FOR_MATCHING(0),

    /**
     * 正在匹配
     */
    MATCHING(1),

    /**
     * 匹配成功
     */
    MATCH_SUCCESS(2),

    /**
     * 匹配失败
     */
    MATCH_FAILED(3);

    companion object {
        fun getEnumByInnerValue(matchTaskStatus: Int?) = values().find { it.matchTaskStatus == matchTaskStatus }
    }

    class MatchStatusEnumDeserializer : StdDeserializer<MatchStatusEnum>(MatchStatusEnum::class.java) {

        override fun deserialize(p: JsonParser, ctx: DeserializationContext): MatchStatusEnum? {
            val node = p.codec.readTree<JsonNode>(p)
            val matchTaskStatus = node.asInt()
            return getEnumByInnerValue(matchTaskStatus)
        }
    }
}