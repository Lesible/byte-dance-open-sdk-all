package com.sumwhy.bytedance.open.api

import com.sumwhy.bytedance.open.model.req.enterprise.BizToolBindItemReq
import com.sumwhy.bytedance.open.model.resp.EnterpriseRet
import com.sumwhy.bytedance.open.model.resp.enterprise.BizToolListResult
import com.sumwhy.bytedance.open.model.resp.enterprise.ItemBindBizToolListResult
import com.sumwhy.bytedance.open.model.resp.enterprise.LeadsUserListResult
import retrofit2.Call
import retrofit2.http.*

/**
 * <p> 企业号接口 </p>
 * <p> create 2021-09-02 18:14 by lesible </p>
 * @author 何嘉豪
 */
interface EnterpriseApi {

    /**
     * 查询企业营销组件
     */
    @GET("enterprise/v1/biztool/list/")
    fun listBizTool(@QueryMap queryMap: Map<String, String>): Call<EnterpriseRet<BizToolListResult>>

    /**
     * 绑定营销组件到视频
     */
    @POST("enterprise/v1/biztool/item/bind/")
    fun bindBizTool2Item(
        @Query("access_token") accessToken: String,
        @Query("open_id") openId: String,
        @Body bizToolBindItemReq: BizToolBindItemReq,
    ): Call<EnterpriseRet<Void>>

    /**
     * 查询视频挂载的营销组件
     */
    @GET("enterprise/v1/biztool/item/bind/list/")
    fun listItemBindBizTool(
        @Query("access_token") accessToken: String,
        @Query("open_id") openId: String,
        @Query("item_id_list") itemIdList: String,
    ): Call<EnterpriseRet<ItemBindBizToolListResult>>

    /**
     * 查询企业号意向用户列表
     */
    @GET("enterprise/v1/leads/user/list/")
    fun listLeadsUser(@QueryMap queryMap: Map<String, String>): Call<EnterpriseRet<LeadsUserListResult>>

}