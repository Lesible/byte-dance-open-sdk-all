package com.sumwhy.bytedance.open.model.resp.poi.supplier

import com.sumwhy.bytedance.open.model.resp.BaseData

/**
 * <p> 抖音 poi 信息 </p>
 * <p> create 2021-08-23 11:23 by lesible </p>
 *
 * @author 何嘉豪
 */
data class QueryPoiResult(
    /**
     * 纬度
     */
    val latitude: Double?,

    /**
     * 抖音POI
     */
    val poiId: String?,

    /**
     * POI
     */
    val poiName: String?,

    /**
     * 高德POI
     */
    val amapId: String?,

    /**
     * POI所在城市
     */
    val city: String?,

    /**
     * 经度
     */
    val longitude: Double?,

    /**
     * POI地址
     */
    val address: String?,

    /**
     * 错误码
     */
    override val errorCode: Int,

    /**
     * 错误码描述
     */
    override val description: String,
) : BaseData(errorCode, description)
