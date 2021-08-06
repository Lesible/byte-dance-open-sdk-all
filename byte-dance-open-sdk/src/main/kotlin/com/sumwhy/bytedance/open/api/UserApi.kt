package com.sumwhy.bytedance.open.api

import com.sumwhy.bytedance.open.model.resp.ByteDanceResp
import com.sumwhy.bytedance.open.model.resp.user.ListFansResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.QueryMap

/**
 * <p> 用户管理接口 </p>
 * <p> create 2021-08-06 17:13 by lesible </p>
 * @author 何嘉豪
 */
interface UserApi {

    @GET("fans/list/")
    fun listFans(@QueryMap queryMap: Map<String, String>): Call<ByteDanceResp<ListFansResult>>

}