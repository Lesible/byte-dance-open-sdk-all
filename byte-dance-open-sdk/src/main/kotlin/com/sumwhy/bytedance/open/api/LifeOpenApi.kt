package com.sumwhy.bytedance.open.api

import com.sumwhy.bytedance.open.model.req.poi.order.*
import com.sumwhy.bytedance.open.model.req.poi.product.SkuSyncReq
import com.sumwhy.bytedance.open.model.req.poi.supplier.SupplierMatchReq
import com.sumwhy.bytedance.open.model.resp.BaseData
import com.sumwhy.bytedance.open.model.resp.ByteDanceResp
import com.sumwhy.bytedance.open.model.resp.poi.order.OrderCancelResult
import com.sumwhy.bytedance.open.model.resp.poi.order.OrderCommitResult
import com.sumwhy.bytedance.open.model.resp.poi.order.OrderPayStatusNoticeResult
import com.sumwhy.bytedance.open.model.resp.poi.order.PreSaleCouponConfirmResult
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
    ): Call<ByteDanceResp<SupplierSyncResult>>

    /**
     * 查询店铺
     */
    @GET("poi/supplier/query")
    fun querySupplier(
        @Query("access_token") accessToken: String,
        @Query("supplier_ext_id") supplierExtId: String,
    ): Call<ByteDanceResp<SupplierQueryResult>>

    /**
     * 查询抖音 poi
     */
    @GET("poi/query")
    fun queryPoi(
        @Query("access_token") accessToken: String,
        @Query("amap_id") amapId: String,
    ): Call<ByteDanceResp<PoiQueryResult>>

    /**
     * 店铺匹配任务结果查询
     */
    @GET("poi/v2/supplier/query/task")
    fun querySupplierMatchResultByTaskIds(
        @Query("access_token") accessToken: String,
        @Query("supplier_task_ids") supplierTaskIds: String,
    ): Call<ByteDanceResp<SupplierQueryTaskResult>>

    /**
     * 店铺匹配任务结果查询
     */
    @GET("poi/v2/supplier/query/task")
    fun querySupplierMatchResultBySupplierExtIds(
        @Query("access_token") accessToken: String,
        @Query("supplier_ext_id") supplierExtIds: String,
    ): Call<ByteDanceResp<SupplierQueryExtResult>>

    /**
     * 同步店铺匹配 poi 任务
     */
    @POST("poi/v2/supplier/match")
    fun syncSupplierMatch(
        @Query("access_token") accessToken: String,
        @Body supplierMatchReq: SupplierMatchReq,
    ): Call<ByteDanceResp<SupplierMatchSyncResult>>

    /**
     * 同步商品 sku
     */
    @POST("poi/sku/sync")
    fun syncSku(
        @Query("access_token") accessToken: String,
        @Body skuSyncReq: SkuSyncReq,
    ): Call<ByteDanceResp<BaseData>>

    /**
     * 同步订单状态
     */
    @POST("poi/order/status")
    fun syncOrderStatus(
        @Query("access_token") accessToken: String,
        @Body orderStatusSyncReq: OrderStatusSyncReq,
    ): Call<ByteDanceResp<BaseData>>

    /**
     * 下单
     */
    @POST("poi/ext/hotel/order/commit")
    fun commitOrderExt(@Body orderCommitReq: OrderCommitReq): Call<ByteDanceResp<OrderCommitResult>>

    /**
     * 支付状态通知
     */
    @POST("poi/ext/hotel/order/status")
    fun notifyOrderPayStatus(@Body orderPayStatusNoticeReq: OrderPayStatusNoticeReq)
            : Call<ByteDanceResp<OrderPayStatusNoticeResult>>

    /**
     * 取消订单
     */
    @POST("poi/ext/hotel/order/cancel")
    fun cancelOrder(@Body orderCancelReq: OrderCancelReq): Call<ByteDanceResp<OrderCancelResult>>

    /**
     * 核销预售券
     */
    @POST("poi/order/confirm")
    fun confirmPreSaleCoupon(
        @Query("access_token") accessToken: String,
        @Body preSaleCouponConfirmReq: PreSaleCouponConfirmReq,
    ): Call<ByteDanceResp<PreSaleCouponConfirmResult>>
}