package com.sumwhy.bytedance.open.client

import com.sumwhy.bytedance.open.api.LifeOpenApi
import com.sumwhy.bytedance.open.model.req.poi.order.*
import com.sumwhy.bytedance.open.model.resp.BaseData
import com.sumwhy.bytedance.open.model.resp.ByteDanceResp
import com.sumwhy.bytedance.open.model.resp.poi.order.OrderCancelResult
import com.sumwhy.bytedance.open.model.resp.poi.order.OrderCommitResult
import com.sumwhy.bytedance.open.model.resp.poi.order.OrderPayStatusNoticeResult
import com.sumwhy.bytedance.open.model.resp.poi.order.PreSaleCouponConfirmResult

/**
 * <p> 生活服务开放能力 - 交易系统接入 </p>
 * <p> create 2021-08-23 14:40 by lesible </p>
 * @author 何嘉豪
 */
class PoiOrderClient(private val lifeOpenApi: LifeOpenApi) {

    /**
     * 订单状态同步
     *
     * @param accessToken 调用凭证
     * @param orderStatusSyncReq 订单状态同步请求
     * @return 订单状态同步结果
     */
    fun syncOrderStatus(accessToken: String, orderStatusSyncReq: OrderStatusSyncReq): ByteDanceResp<BaseData>? {
        val syncResult = lifeOpenApi.syncOrderStatus(accessToken, orderStatusSyncReq).execute()
        return if (syncResult.isSuccessful) syncResult.body() else null
    }

    /**
     * 下单
     *
     * @param orderCommitReq 下单请求
     * @return 下单结果
     */
    fun commitOrderExt(orderCommitReq: OrderCommitReq): ByteDanceResp<OrderCommitResult>? {
        val commitOrderResult = lifeOpenApi.commitOrderExt(orderCommitReq).execute()
        return if (commitOrderResult.isSuccessful) commitOrderResult.body() else null
    }

    /**
     * 支付状态通知
     *
     * @param orderPayStatusNoticeReq 订单支付状态通知请求
     * @return 订单支付状态通知结果
     */
    fun notifyOrderPayStatus(orderPayStatusNoticeReq: OrderPayStatusNoticeReq)
            : ByteDanceResp<OrderPayStatusNoticeResult>? {
        val notifyOrderPayStatusResult = lifeOpenApi.notifyOrderPayStatus(orderPayStatusNoticeReq).execute()
        return if (notifyOrderPayStatusResult.isSuccessful) notifyOrderPayStatusResult.body() else null
    }

    /**
     * 取消订单
     *
     * @param orderCancelReq 订单取消请求
     * @return 订单取消结果
     */
    fun cancelOrder(orderCancelReq: OrderCancelReq): ByteDanceResp<OrderCancelResult>? {
        val orderCancelResult = lifeOpenApi.cancelOrder(orderCancelReq).execute()
        return if (orderCancelResult.isSuccessful) orderCancelResult.body() else null
    }

    /**
     * 核销预售券
     *
     * @param accessToken 请求凭证
     * @param preSaleCouponConfirmReq 核销预授权请求信息
     * @return 预授权核销结果
     */
    fun confirmPreSaleCoupon(accessToken: String, preSaleCouponConfirmReq: PreSaleCouponConfirmReq)
            : ByteDanceResp<PreSaleCouponConfirmResult>? {
        val confirmResult = lifeOpenApi.confirmPreSaleCoupon(accessToken, preSaleCouponConfirmReq).execute()
        return if (confirmResult.isSuccessful) confirmResult.body() else null
    }
}