package com.sumwhy.bytedance.open.model.resp.poi.supplier

import com.sumwhy.bytedance.open.model.resp.BaseData
import com.sumwhy.bytedance.open.model.resp.poi.supplier.enumeration.MatchStatusEnum

/**
 * <p> 店铺匹配状态结果 </p>
 * <p> create 2021-08-23 11:40 by lesible </p>
 * @author 何嘉豪
 */
data class SupplierQueryExtResult(

    /**
     * 匹配状态信息
     */
    val matchResultList: List<MatchResult>?,

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
 * <p> 店铺匹配结果 </p>
 * <p> create 2021-08-23 11:40 by lesible </p>
 * @author 何嘉豪
 */
data class MatchResult(

    /**
     * 第三方商户ID
     */
    val supplierExtId: String?,

    /**
     * 第三方商户ID
     */
    val taskId: String?,

    /**
     * 抖音POI
     */
    val poiId: String?,

    /**
     * 匹配状态，0-没有匹配，1-匹配中，2-匹配完成
     */
    val status: MatchStatusEnum?,
)