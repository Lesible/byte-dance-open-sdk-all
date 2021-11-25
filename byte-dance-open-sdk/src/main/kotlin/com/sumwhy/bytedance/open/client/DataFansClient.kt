package com.sumwhy.bytedance.open.client

import com.sumwhy.bytedance.open.api.DataApi
import com.sumwhy.bytedance.open.model.req.data.DataBaseParam
import com.sumwhy.bytedance.open.model.resp.ByteDanceResp
import com.sumwhy.bytedance.open.model.resp.data.fans.FansDataRet

/**
 * <p> 粉丝数据信息客户端 </p>
 * <p> created at 2021-11-25 14:36 by lesible </p>
 * @author 何嘉豪
 */
class DataFansClient(private val dataApi: DataApi) {

    /**
     * 查询用户粉丝数据
     *
     * @param dataBaseParam 数据查询基础参数
     * @return 用户粉丝数据
     */
    fun getFansData(dataBaseParam: DataBaseParam): ByteDanceResp<FansDataRet>? {
        val fansData = dataApi.getFansData(dataBaseParam.openId,dataBaseParam.accessToken).execute()
        return if (fansData.isSuccessful) fansData.body() else null
    }

}