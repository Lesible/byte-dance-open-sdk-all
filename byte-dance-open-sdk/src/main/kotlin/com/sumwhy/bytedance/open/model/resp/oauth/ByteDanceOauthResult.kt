package com.sumwhy.bytedance.open.model.resp.oauth

/**
 * <p> @date: 2021-07-28 15:58</p>
 * @author 何嘉豪
 */
data class ByteDanceOauthResult<T>(val data: T, val message: String) {

    fun isSuccessful() = "success" == message

}