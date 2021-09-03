package com.sumwhy.bytedance.open.client

import com.sumwhy.bytedance.open.api.EnterpriseApi
import com.sumwhy.bytedance.open.model.req.enterprise.BizToolBindItemReq
import com.sumwhy.bytedance.open.model.req.enterprise.BizToolListReq
import com.sumwhy.bytedance.open.model.resp.EnterpriseRet
import com.sumwhy.bytedance.open.model.resp.enterprise.BizToolListResult
import com.sumwhy.bytedance.open.model.resp.enterprise.ItemBindBizToolListResult

/**
 * <p> 企业号接口请求客户端 </p>
 * <p> create 2021-09-02 18:36 by lesible </p>
 *
 * @author 何嘉豪
 */
class EnterpriseClient(private val enterpriseApi: EnterpriseApi) {

    /**
     * 企业号读取营销组件列表
     *
     * @param bizToolListReq 营销组件查询参数
     * @return 营销组件查询结果
     */
    fun listBizTool(bizToolListReq: BizToolListReq): EnterpriseRet<BizToolListResult>? {
        val bizToolResult = enterpriseApi.listBizTool(bizToolListReq.toParamMap()).execute()
        return if (bizToolResult.isSuccessful) bizToolResult.body() else null
    }

    /**
     * 绑定营销组件到视频
     *
     * @param accessToken 调用凭证
     * @param openId 用户唯一标识
     * @param bizToolBindItemReq 绑定请求参数
     * @return 绑定结果
     */
    fun bindBizTool2Item(
        accessToken: String, openId: String, bizToolBindItemReq: BizToolBindItemReq,
    ): EnterpriseRet<Void>? {
        val bindResult = enterpriseApi.bindBizTool2Item(accessToken, openId, bizToolBindItemReq).execute()
        return if (bindResult.isSuccessful) bindResult.body() else null
    }

    /**
     * 查询视频挂载的营销组件
     *
     * @param accessToken 调用凭证
     * @param openId 用户唯一凭证
     * @param itemIdList itemId 集合
     * @return 视频挂载工具列表
     */
    fun listItemBindBizTool(
        accessToken: String,
        openId: String,
        itemIdList: List<String>,
    ): EnterpriseRet<ItemBindBizToolListResult>? {
        val itemIdListStr = itemIdList.joinToString(separator = ",") { it }
        val bindListResult = enterpriseApi.listItemBindBizTool(accessToken, openId, itemIdListStr).execute()
        return if (bindListResult.isSuccessful) bindListResult.body() else null
    }

}
