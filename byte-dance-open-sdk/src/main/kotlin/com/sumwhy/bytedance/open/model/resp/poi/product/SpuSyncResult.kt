package com.sumwhy.bytedance.open.model.resp.poi.product

import com.sumwhy.bytedance.open.model.resp.BaseData

/**
 *
 * <p> 商品 spu 同步结果  </p>
 * @author 何嘉豪
 */
data class SpuSyncResult(

    /**
     * 抖音平台 SPU ID
     */
    val spuId: String?,

    /**
     * 错误码
     */
    override val errorCode: Int,

    /**
     * 错误码描述
     */
    override val description: String,
) : BaseData(errorCode, description)