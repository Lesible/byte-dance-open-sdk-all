package com.sumwhy.bytedance.open.model.resp

/**
 * <p>  </p>
 * <p> create 2021-08-02 14:58 by lesible</p>
 * @author 何嘉豪
 */
data class ByteDanceResp<T : BaseData>(val data: T, val extra: ExtraInfo)