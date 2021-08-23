package com.sumwhy.bytedance.open.model.resp.poi.supplier

import com.sumwhy.bytedance.open.model.resp.BaseData
import com.sumwhy.bytedance.open.model.resp.poi.supplier.enumeration.MatchTaskStatusEnum

/**
 * <p> 店铺匹配任务结果 </p>
 * <p> create 2021-08-23 11:40 by lesible </p>
 * @author 何嘉豪
 */
data class QuerySupplierTaskResult(

    /**
     * 匹配状态信息
     */
    val matchResultList: List<MatchTaskResult>?,

    /**
     * 错误码
     */
    override val errorCode: Int,

    /**
     * 错误码描述
     */
    override val description: String,
) : BaseData(errorCode, description)

/**
 * <p> 店铺匹配任务结果 </p>
 * <p> create 2021-08-23 11:40 by lesible </p>
 * @author 何嘉豪
 */
data class MatchTaskResult(

    /**
     * POI所在省份
     */
    val province: String?,

    /**
     * POI地址
     */
    val address: String?,

    /**
     * 抖音POI
     */
    val poiId: String?,

    /**
     * POI名称
     */
    val poiName: String?,

    /**
     * 匹配状态描述
     */
    val mismatchStatusDesc: String?,

    /**
     * 第三方商户ID
     */
    val supplierExtId: String?,

    /**
     * POI所在城市
     */
    val city: String?,

    /**
     * 其他信息
     */
    val extra: String?,

    /**
     * 匹配状态，0-等待匹配，1-正在匹配，2-匹配成功，3-匹配失败
     */
    val matchStatus: MatchTaskStatusEnum?,
)