package com.sumwhy.bytedance.open.model.resp.poi.product

import com.sumwhy.bytedance.open.model.resp.BaseData

/**
 * <p> 达人分佣配置同步结果 </p>
 * <p> create 2021-08-27 11:01 by lesible </p>
 * @author 何嘉豪
 */
class SpuTakeRateSyncResult(

    val spuId: String? = null,

    /**
     * 错误码
     */
    override val errorCode: Int,

    /**
     * 错误码描述
     */
    override val description: String,
) : BaseData(errorCode, description)