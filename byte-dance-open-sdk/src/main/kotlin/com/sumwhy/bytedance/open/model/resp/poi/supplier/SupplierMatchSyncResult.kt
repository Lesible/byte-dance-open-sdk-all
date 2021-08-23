package com.sumwhy.bytedance.open.model.resp.poi.supplier

import com.sumwhy.bytedance.open.model.resp.BaseData

/**
 * <p> 店铺匹配同步结果 </p>
 * <p> create 2021-08-23 13:55 by lesible </p>
 * @author 何嘉豪
 */
data class SupplierMatchSyncResult(

    /**
     * 抖音平台任务 id
     */
    val taskId: String?,

    /**
     * 上传状态(1:成功，2:失败)
     */
    val is_success: Int?,

    /**
     * 错误码
     */
    override val errorCode: Int,

    /**
     * 错误码描述
     */
    override val description: String,
) : BaseData(errorCode, description)