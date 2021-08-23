package com.sumwhy.bytedance.open.client

import com.sumwhy.bytedance.open.api.LifeOpenApi
import com.sumwhy.bytedance.open.model.req.poi.supplier.SupplierMatchReq
import com.sumwhy.bytedance.open.model.resp.ByteDanceResp
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
     */
    fun syncSupplier(accessToken: String, syncSupplier: SyncSupplier): ByteDanceResp<SyncSupplierResult>? {
        val syncResult = lifeOpenApi.syncSupplier(accessToken, syncSupplier).execute()
        return if (syncResult.isSuccessful) syncResult.body() else null
    }

    /**
     * 查询店铺
     *
     * @param accessToken 请求凭证
     * @param supplierExtId 接入方店铺 id
     */
    fun querySupplier(accessToken: String, supplierExtId: String): ByteDanceResp<QuerySupplierResult>? {
        val queryResult = lifeOpenApi.querySupplier(accessToken, supplierExtId).execute()
        return if (queryResult.isSuccessful) queryResult.body() else null
    }

    /**
     * 查询抖音 poi
     *
     * @param accessToken 请求凭证
     * @param amapId 高德 poi id
     */
    fun queryPoi(accessToken: String, amapId: String): ByteDanceResp<QueryPoiResult>? {
        val queryResult = lifeOpenApi.queryPoi(accessToken, amapId).execute()
        return if (queryResult.isSuccessful) queryResult.body() else null
    }

    /**
     * 根据匹配任务 taskId 查询店铺匹配任务结果
     *
     * @param accessToken 请求凭证
     * @param supplierTaskIds 第三方上传任务 id 列表 单次查询最多10个任务。
     */
    fun querySupplierMatchResultByTaskIds(accessToken: String, supplierTaskIds: List<String>)
            : ByteDanceResp<QuerySupplierTaskResult>? {
        val queryResult = lifeOpenApi.querySupplierMatchResultByTaskIds(
            accessToken, supplierTaskIds.joinToString()).execute()
        return if (queryResult.isSuccessful) queryResult.body() else null
    }

    /**
     * 根据第三方店铺 id 查询店铺匹配任务结果
     *
     * @param accessToken 请求凭证
     * @param supplierExtIds 第三方店铺 id 列表，单次查询最多50个店铺。
     */
    fun querySupplierMatchResultBySupplierExtIds(accessToken: String, supplierExtIds: List<String>)
            : ByteDanceResp<QuerySupplierExtResult>? {
        val queryResult = lifeOpenApi.querySupplierMatchResultBySupplierExtIds(
            accessToken, supplierExtIds.joinToString()).execute()
        return if (queryResult.isSuccessful) queryResult.body() else null
    }

    /**
     * 同步店铺匹配 poi 任务
     */
    fun syncSupplierMatch(accessToken: String, supplierMathReq: SupplierMatchReq)
            : ByteDanceResp<SupplierMatchSyncResult>? {
        val syncResult = lifeOpenApi.syncSupplierMatch(accessToken, supplierMathReq).execute()
        return if (syncResult.isSuccessful) syncResult.body() else null
    }

}