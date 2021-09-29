package com.sumwhy.bytedance.open.client

import com.sumwhy.bytedance.open.api.LifeOpenApi
import com.sumwhy.bytedance.open.model.req.poi.supplier.SupplierMatchReq
import com.sumwhy.bytedance.open.model.resp.ByteDanceResp
import com.sumwhy.bytedance.open.model.resp.poi.PoiResp
import com.sumwhy.bytedance.open.model.resp.poi.supplier.*
import com.sumwhy.bytedance.open.model.universal.poi.supplier.SyncSupplier

/**
 * <p> 生活服务开放能力 - 商铺接入 </p>
 * <p> create 2021-08-22 17:09 by lesible </p>
 * @author 何嘉豪
 */
class PoiSupplierClient(private val lifeOpenApi: LifeOpenApi) {

    /**
     * 同步店铺
     *
     * @param accessToken 请求凭证
     * @param syncSupplier 同步店铺参数
     * @return 同步店铺结果
     */
    fun syncSupplier(accessToken: String, syncSupplier: SyncSupplier): ByteDanceResp<SupplierSyncResult>? {
        val syncResult = lifeOpenApi.syncSupplier(accessToken, syncSupplier).execute()
        return if (syncResult.isSuccessful) syncResult.body() else null
    }

    /**
     * 查询店铺
     *
     * @param accessToken 请求凭证
     * @param supplierExtId 接入方店铺 id
     * @return 查询到的店铺信息
     */
    fun querySupplier(accessToken: String, supplierExtId: String): ByteDanceResp<SupplierQueryResult>? {
        val queryResult = lifeOpenApi.querySupplier(accessToken, supplierExtId).execute()
        return if (queryResult.isSuccessful) queryResult.body() else null
    }

    /**
     * 查询抖音 poi
     *
     * @param accessToken 请求凭证
     * @param amapId 高德 poi id
     * @return 根据高德 poiId 查询到的 抖音 poiId
     */
    fun queryPoi(accessToken: String, amapId: String): ByteDanceResp<PoiQueryResult>? {
        val queryResult = lifeOpenApi.queryPoi(accessToken, amapId).execute()
        return if (queryResult.isSuccessful) queryResult.body() else null
    }

    /**
     * 根据匹配任务 taskId 查询店铺匹配任务结果
     *
     * @param accessToken 请求凭证
     * @param supplierTaskIds 第三方上传任务 id 列表 单次查询最多10个任务。
     * @return 店铺匹配任务结果
     */
    fun querySupplierMatchResultByTaskIds(accessToken: String, supplierTaskIds: List<String>)
            : ByteDanceResp<SupplierQueryTaskResult>? {
        val queryResult = lifeOpenApi.querySupplierMatchResultByTaskIds(
            accessToken, supplierTaskIds.joinToString()).execute()
        return if (queryResult.isSuccessful) queryResult.body() else null
    }

    /**
     * 根据第三方店铺 id 查询店铺匹配任务结果
     *
     * @param accessToken 请求凭证
     * @param supplierExtIds 第三方店铺 id 列表，单次查询最多50个店铺。
     * @return 店铺匹配任务结果
     */
    fun querySupplierMatchResultBySupplierExtIds(accessToken: String, supplierExtIds: List<String>)
            : ByteDanceResp<SupplierQueryExtResult>? {
        val queryResult = lifeOpenApi.querySupplierMatchResultBySupplierExtIds(
            accessToken, supplierExtIds.joinToString()).execute()
        return if (queryResult.isSuccessful) queryResult.body() else null
    }

    /**
     * 同步店铺匹配 poi 任务
     *
     * @param accessToken 请求凭证
     * @param supplierMatchReq 同步请求
     * @return 同步店铺结果
     */
    fun syncSupplierMatch(accessToken: String, supplierMatchReq: SupplierMatchReq)
            : PoiResp<SupplierMatchSyncResult>? {
        val syncResult = lifeOpenApi.syncSupplierMatch(accessToken, supplierMatchReq).execute()
        return if (syncResult.isSuccessful) syncResult.body() else null
    }

}