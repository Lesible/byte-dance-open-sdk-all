package com.sumwhy.bytedance.open.model.req.poi.product

import com.sumwhy.bytedance.open.model.universal.poi.enumeration.OnlineStatusEnum

/**
 * <p> 同步 sku 状态请求 </p>
 * <p> create 2021-08-26 17:51 by lesible </p>
 * @author 何嘉豪
 */
class SpuStatusSyncReq(

    /**
     * 接入方商品ID列表
     */
    val spuExtIdList: List<String>,


    /**
     * SPU状态，
     */
    val status: OnlineStatusEnum,
)
