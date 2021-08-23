package com.sumwhy.bytedance.open.client

import com.sumwhy.bytedance.open.api.LifeOpenApi
import com.sumwhy.bytedance.open.model.req.poi.product.SkuSyncReq
import com.sumwhy.bytedance.open.model.resp.BaseData
import com.sumwhy.bytedance.open.model.resp.ByteDanceResp

/**
 * <p> 生活服务开放能力 - 商品库接入 </p>
 * <p> create 2021-08-23 14:40 by lesible </p>
 * @author 何嘉豪
 */
class PoiProductClient(private val lifeOpenApi: LifeOpenApi) {

    /**
     * 同步商品 sku
     *
     * @param accessToken 调用凭证
     * @param skuSyncReq sku 同步请求
     * @return 商品数据同步结果
     */
    fun syncSku(accessToken: String, skuSyncReq: SkuSyncReq): ByteDanceResp<BaseData>? {
        val syncResult = lifeOpenApi.syncSku(accessToken, skuSyncReq).execute()
        return if (syncResult.isSuccessful) syncResult.body() else null
    }


}