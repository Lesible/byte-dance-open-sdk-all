package com.sumwhy.bytedance.open.model.req.poi.product

/**
 * <p> 同步 sku 库存请求 </p>
 * <p> create 2021-08-26 18:15 by lesible </p>
 * @author 何嘉豪
 */
class SpuStockSyncReq(

    /**
     * 接入方商品 id
     */
    val spuExtId: String,

    /**
     * 库存
     */
    val stock: Long,
)
