package com.sumwhy.bytedance.open.client

import com.sumwhy.bytedance.open.api.LifeOpenApi
import com.sumwhy.bytedance.open.model.req.poi.product.*
import com.sumwhy.bytedance.open.model.resp.BaseData
import com.sumwhy.bytedance.open.model.resp.poi.PoiResp
import com.sumwhy.bytedance.open.model.resp.poi.product.*

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
    fun syncSku(accessToken: String, skuSyncReq: SkuSyncReq): PoiResp<BaseData>? {
        val syncResult = lifeOpenApi.syncSku(accessToken, skuSyncReq).execute()
        return if (syncResult.isSuccessful) syncResult.body() else null
    }

    /**
     * 多门店 spu 同步
     * @param accessToken 调用凭证
     * @param spuSyncReq spu 同步请求
     * @return 商品 spu 同步结果
     */
    fun syncSpu(accessToken: String, spuSyncReq: SpuSyncReq): PoiResp<SpuSyncResult>? {
        val syncResult = lifeOpenApi.syncSpu(accessToken, spuSyncReq).execute()
        return if (syncResult.isSuccessful) syncResult.body() else null
    }

    /**
     * 多门店 spu 状态同步
     * @param accessToken 调用凭证
     * @param spuStatusSyncReq spu 状态同步请求
     * @return 商品 spu 状态同步结果
     */
    fun syncSpuStatus(
        accessToken: String,
        spuStatusSyncReq: SpuStatusSyncReq,
    ): PoiResp<SpuStatusSyncResult>? {
        val syncResult = lifeOpenApi.syncSpuStatus(accessToken, spuStatusSyncReq).execute()
        return if (syncResult.isSuccessful) syncResult.body() else null
    }

    /**
     * 多门店 spu 库存同步
     *
     * @param accessToken 调用凭证
     * @param spuStockSyncReq spu 库存同步请求
     * @return 商品 spu 库存同步结果
     */
    fun syncSpuStock(
        accessToken: String, spuStockSyncReq: SpuStockSyncReq,
    ): PoiResp<SpuStockSyncResult>? {
        val syncResult = lifeOpenApi.syncSpuStock(accessToken, spuStockSyncReq).execute()
        return if (syncResult.isSuccessful) syncResult.body() else null
    }

    /**
     * 多门店 spu 信息同步
     *
     * @param spuInfoSyncReq spu 信息同步请求
     * @return 商品 spu 信息同步结果
     */
    fun syncSpuInfo(spuInfoSyncReq: SpuInfoSyncReq): PoiResp<SpuInfoSyncResult>? {
        val syncResult = lifeOpenApi.syncSpuInfo(spuInfoSyncReq.toParamMap()).execute()
        return if (syncResult.isSuccessful) syncResult.body() else null
    }

    /**
     * 商品达人分佣配置同步
     *
     * @param accessToken 调用凭证
     * @param spuTakeRateSyncReq 商品达人分佣配置同步请求
     * @return 商品达人分佣配置同步结果
     */
    fun syncSpuTakeRate(
        accessToken: String,
        spuTakeRateSyncReq: SpuTakeRateSyncReq,
    ): PoiResp<SpuTakeRateSyncResult>? {
        val syncResult = lifeOpenApi.syncSpuTakeRate(accessToken, spuTakeRateSyncReq).execute()
        return if (syncResult.isSuccessful) syncResult.body() else null
    }

}