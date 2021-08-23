package com.sumwhy.bytedance.open.api

import com.sumwhy.bytedance.open.model.req.poi.supplier.SupplierMatchReq
import com.sumwhy.bytedance.open.model.resp.ByteDanceResp
import com.sumwhy.bytedance.open.model.resp.poi.supplier.*
import com.sumwhy.bytedance.open.model.universal.poi.supplier.SyncSupplier
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * <p> 本地服务开放能力 </p>
 * <p> create 2021-08-20 11:20 by lesible </p>
 * @author 何嘉豪
 */
interface LifeOpenApi {

    /**
     * 商铺同步
     */
    @POST("poi/supplier/sync")
    fun syncSupplier(
        @Query("access_token") accessToken: String,
        @Body syncSupplier: SyncSupplier,
    ): Call<ByteDanceResp<SyncSupplierResult>>

    /**
     * 查询店铺
     */
    @GET("poi/supplier/query")
    fun querySupplier(
        @Query("access_token") accessToken: String,
        @Query("supplier_ext_id") supplierExtId: String,
    ): Call<ByteDanceResp<QuerySupplierResult>>

    /**
     * 查询抖音 poi
     */
    @GET("poi/query")
    fun queryPoi(
        @Query("access_token") accessToken: String,
        @Query("amap_id") amapId: String,
    ): Call<ByteDanceResp<QueryPoiResult>>

    /**
     * 店铺匹配任务结果查询
     */
    @GET("poi/v2/supplier/query/task")
    fun querySupplierMatchResultByTaskIds(
        @Query("access_token") accessToken: String,
        @Query("supplier_task_ids") supplierTaskIds: String,
    ): Call<ByteDanceResp<QuerySupplierTaskResult>>

    /**
     * 店铺匹配任务结果查询
     */
    @GET("poi/v2/supplier/query/task")
    fun querySupplierMatchResultBySupplierExtIds(
        @Query("access_token") accessToken: String,
        @Query("supplier_ext_id") supplierExtIds: String,
    ): Call<ByteDanceResp<QuerySupplierExtResult>>

    /**
     * 同步店铺匹配 poi 任务
     */
    @POST("poi/v2/supplier/match")
    fun syncSupplierMatch(
        @Query("access_token") accessToken: String,
        @Body supplierMathReq: SupplierMatchReq,
    ): Call<ByteDanceResp<SupplierMatchSyncResult>>

}