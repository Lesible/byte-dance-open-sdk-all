package com.sumwhy.bytedance.open.model.resp.poi

import com.sumwhy.bytedance.open.model.resp.BaseData

/**
 * <p>  </p>
 * <p> create 2021-09-29 14:28 by lesible </p>
 * @author 何嘉豪
 */
data class PoiResp<T : BaseData>(val data: T, val extra: SimpleExtra) {
    fun isSuccessful() = data.errorCode == 0
}