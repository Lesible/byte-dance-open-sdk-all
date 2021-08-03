package com.sumwhy.bytedance.open.model.resp

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * <p>  </p>
 * <p> create 2021-08-02 14:58 by lesible</p>
 * @author 何嘉豪
 */
data class ExtraInfo(

    /**
     * 子错误码
     */
    val subErrorCode: Int,

    /**
     * 子错误码描述
     */
    val subDescription: String,

    /**
     * 毫秒级时间戳
     */
    val now: Long,

    /**
     * 标识请求的唯一 id
     */
    @JsonProperty("logid")
    val logId: String,

    /**
     * 错误码描述
     */
    override val description: String,

    /**
     * 错误码
     */
    override val errorCode: Int,
) : BaseData(errorCode, description)

