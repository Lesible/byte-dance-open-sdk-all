package com.sumwhy.bytedance.open.client

import com.sumwhy.bytedance.open.api.LifeOpenApi
import com.sumwhy.bytedance.open.model.req.poi.supplier.SyncSupplierReq
import com.sumwhy.bytedance.open.model.resp.ByteDanceResp
import com.sumwhy.bytedance.open.model.resp.poi.supplier.SyncSupplierResult

/**
 * <p> 生活服务开放能力 - 商铺接入 </p>
 * <p> create 2021-08-22 17:09 by lesible </p>
 * @author 何嘉豪
 */
class PoiSupplierClient(private val lifeOpenApi: LifeOpenApi) {

    fun syncSupplier(accessToken: String, syncSupplierReq: SyncSupplierReq): ByteDanceResp<SyncSupplierResult>? {
        val syncResult = lifeOpenApi.syncSupplier(accessToken, syncSupplierReq).execute()
        return if (syncResult.isSuccessful) syncResult.body() else null
    }

}