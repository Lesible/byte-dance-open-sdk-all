package com.sumwhy.bytedance.open.model.resp

data class EnterpriseRet<T>(

    /**
     * 业务参数
     */
    val data: T?,

    /**
     * 公共参数
     */
    val base: BaseInfo,
)

data class BaseInfo(

    /**
     * 请求日志ID
     */
    val logId: String,

    /**
     * 网关状态码
     */
    val gatewayCode: Int,

    /**
     * 网关状态信息
     */
    val gatewayMsg: String,

    /**
     * 业务状态码
     */
    val bizCode: Int,

    /**
     * 业务状态信息
     */
    val bizMsg: String,

    ) {
    fun isSuccessful() = (0 == gatewayCode && 0 == bizCode)
}
