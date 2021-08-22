package com.sumwhy.bytedance.open.api

import com.sumwhy.bytedance.open.model.req.poi.supplier.SyncSupplierReq
import com.sumwhy.bytedance.open.model.resp.ByteDanceResp
import com.sumwhy.bytedance.open.model.resp.poi.supplier.SyncSupplierResult
import retrofit2.Call
import retrofit2.http.Body
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
        @Body syncSupplierReq: SyncSupplierReq,
    ): Call<ByteDanceResp<SyncSupplierResult>>


}