package com.sumwhy.bytedance.open.model.resp.poi.product

import com.sumwhy.bytedance.open.model.resp.BaseData

/**
 *
 * <p> 商品 spu 同步结果  </p>
 * @author 何嘉豪
 */
data class SpuInfoSyncResult(

    /**
     * 状态同步成功的 spuExtId 列表
     */
    val spuExtIdList: List<String>?,

    /**
     * 错误码
     */
    override val errorCode: Int,

    /**
     * 错误码描述
     */
    override val description: String,
) : BaseData(errorCode, description)
