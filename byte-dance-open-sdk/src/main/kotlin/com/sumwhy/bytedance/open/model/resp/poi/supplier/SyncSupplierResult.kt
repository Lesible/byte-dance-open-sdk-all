package com.sumwhy.bytedance.open.model.resp.poi.supplier

import com.sumwhy.bytedance.open.model.resp.BaseData

/**
 * <p> 商铺同步返回 </p>
 * <p> create 2021-08-20 16:40 by lesible </p>
 * @author 何嘉豪
 */
data class SyncSupplierResult(
    /**
     * 结果集
     */
    val supplierId: String?,

    /**
     * 错误码描述
     */
    override val description: String,

    /**
     * 错误码
     */
    override val errorCode: Int,
) : BaseData(errorCode, description)