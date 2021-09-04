package com.sumwhy.bytedance.open.model.req.enterprise

import com.sumwhy.bytedance.open.model.universal.enterprise.enumeration.AppointmentTypeEnum
import java.time.LocalDateTime
import java.time.ZoneOffset

/**
 * 企业号意向用户列表参数
 */
class LeadsUserListReq private constructor(builder: Builder) {

    /**
     * 接口调用凭证
     */
    private val accessToken = builder.accessToken

    /**
     * 用户唯一标识
     */
    private val openId = builder.openId

    /**
     * 预约类型列表
     */
    private val appointmentTypeList = builder.appointmentTypeList

    /**
     * 开始时间
     */
    private val startTime = builder.startTime

    /**
     * 结束时间
     */
    private val endTime = builder.endTime

    /**
     * 当前页码 从 0 开始
     */
    private val page = builder.page

    /**
     * 每页大小
     */
    private val pageSize = builder.pageSize

    /**
     * 员工号 idList
     */
    private val referUserIds = builder.referUserIds

    fun toParamMap(): Map<String, String> {
        val map = mutableMapOf(
            "access_token" to accessToken,
            "open_id" to openId,
            "appointment_type_list" to appointmentTypeList.joinToString(separator = ",") { it.appointmentType.toString() },
            "start_time" to startTime.toEpochSecond(ZoneOffset.of("+8")).toString(),
            "end_time" to endTime.toEpochSecond(ZoneOffset.of("+8")).toString(),
            "page" to page.toString(),
            "page_size" to pageSize.toString()
        )
        if (referUserIds != null) {
            map["refer_user_ids"] = referUserIds.joinToString(separator = ",")
        }
        return map.toMap()
    }

    companion object {

        @JvmStatic
        fun builder(
            accessToken: String,
            openId: String,
            appointmentTypeList: List<AppointmentTypeEnum>,
            startTime: LocalDateTime,
            endTime: LocalDateTime,
            page: Int,
            pageSize: Int,
        ) = Builder(accessToken, openId, appointmentTypeList, startTime, endTime, page, pageSize)

    }

    class Builder(
        val accessToken: String,
        val openId: String,
        val appointmentTypeList: List<AppointmentTypeEnum>,
        val startTime: LocalDateTime,
        val endTime: LocalDateTime,
        val page: Int,
        val pageSize: Int,
    ) {
        var referUserIds: List<String>? = null

        fun referUserIds(referUserIds: List<String>): Builder {
            this.referUserIds = referUserIds
            return this
        }

        fun build() = LeadsUserListReq(this)

    }

}
