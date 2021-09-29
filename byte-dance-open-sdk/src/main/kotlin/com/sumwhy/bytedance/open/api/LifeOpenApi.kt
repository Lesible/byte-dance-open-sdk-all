package com.sumwhy.bytedance.open.api

import com.sumwhy.bytedance.open.model.req.poi.order.*
import com.sumwhy.bytedance.open.model.req.poi.product.*
import com.sumwhy.bytedance.open.model.req.poi.supplier.SupplierMatchReq
import com.sumwhy.bytedance.open.model.resp.BaseData
import com.sumwhy.bytedance.open.model.resp.ByteDanceResp
import com.sumwhy.bytedance.open.model.resp.poi.PoiResp
import com.sumwhy.bytedance.open.model.resp.poi.order.*
import com.sumwhy.bytedance.open.model.resp.poi.product.*
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
    ): Call<PoiResp<SupplierMatchSyncResult>>

    /**
     * 同步商品 sku
     */
    @POST("poi/sku/sync")
    fun syncSku(
        @Query("access_token") accessToken: String,
        @Body skuSyncReq: SkuSyncReq,
    ): Call<ByteDanceResp<BaseData>>

    /**
     * 多门店 spu 同步
     */
    @POST("poi/v2/spu/sync")
    fun syncSpu(
        @Query("access_token") accessToken: String,
        @Body spuSyncReq: SpuSyncReq,
    ): Call<ByteDanceResp<SpuSyncResult>>

    /**
     * 多门店 spu 状态同步
     */
    @POST("poi/v2/spu/status_sync")
    fun syncSpuStatus(
        @Query("access_token") accessToken: String,
        @Body spuStatusSyncReq: SpuStatusSyncReq,
    ): Call<ByteDanceResp<SpuStatusSyncResult>>

    /**
     * 多门店 spu 库存同步
     */
    @POST("poi/v2/spu/stock_update")
    fun syncSpuStock(
        @Query("access_token") accessToken: String,
        @Body spuStockSyncReq: SpuStockSyncReq,
    ): Call<ByteDanceResp<SpuStockSyncResult>>

    /**
     * 多门店 spu 信息同步
     */
    @POST("poi/v2/spu/get")
    fun syncSpuInfo(
        @Query("access_token") accessToken: String,
        @Body spuInfoSyncReq: SpuInfoSyncReq,
    ): Call<ByteDanceResp<SpuInfoSyncResult>>

    /**
     * 商品达人分佣配置
     */
    @POST("poi/v2/spu/take_rate/sync")
    fun syncSpuTakeRate(
        @Query("access_token") accessToken: String,
        @Body spuTakeRateSyncReq: SpuTakeRateSyncReq,
    ): Call<ByteDanceResp<SpuTakeRateSyncResult>>

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

    /**
     * 获取下载账单 token
     */
    @GET("poi/order/bill/token")
    fun getBillToken(
        @Query("access_token") accessToken: String,
        @Query("bill_date") billDate: String,
    ): Call<ByteDanceResp<BillTokenResult>>

    /**
     * 获取下载订单 token
     */
    @GET("poi/order/list/token")
    fun getOrderToken(
        @Query("access_token") accessToken: String,
        @Query("order_date") orderDate: String,
    ): Call<ByteDanceResp<OrderTokenResult>>

    /**
     * 同步外部订单到抖音订单
     */
    @POST("poi/order/sync")
    fun syncOrder(
        @Query("access_token") accessToken: String,
        @Body orderSyncReq: OrderSyncReq,
    ): Call<ByteDanceResp<OrderSyncResult>>

}