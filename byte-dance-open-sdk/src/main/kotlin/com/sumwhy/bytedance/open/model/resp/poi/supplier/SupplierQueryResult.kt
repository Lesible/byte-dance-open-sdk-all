package com.sumwhy.bytedance.open.model.resp.poi.supplier

import com.sumwhy.bytedance.open.model.resp.BaseData
import com.sumwhy.bytedance.open.model.universal.poi.supplier.SyncSupplier

/**
 * <p> 店铺查询结果 </p>
 * <p> create 2021-08-23 09:40 by lesible </p>
 *
 * @author 何嘉豪
 */
data class SupplierQueryResult(

    /**
     * 数据详情
     */
    val dataDetail: SyncSupplier?,

    /**
     * 数据同步结果
     */
    val syncStatus: SyncStatus?,

    /**
     * 错误码描述
     */
    override val description: String,

    /**
     * 错误码
     */
    override val errorCode: Int,
) : BaseData(errorCode, description)

/**
 * <p> 数据同步结果 </p>
 * <p> create 2021-08-23 10:04 by lesible </p>
 * @author 何嘉豪
 */
data class SyncStatus(

    /**
     * 同步失败原因，抖音风控政策问题，
     * 该字段无法提供太多信息，目前审核不通过联系抖音运营做进一步处理
     */
    val failReason: String?,

    /**
     * 最近一次酒店同步状态, 0 - 未处理; 1 - 通过; 2 - 未通过
     */
    val lastSyncStatus: Int?,

    )