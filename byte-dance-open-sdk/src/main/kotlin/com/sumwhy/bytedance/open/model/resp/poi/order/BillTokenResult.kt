package com.sumwhy.bytedance.open.model.resp.poi.order

import com.sumwhy.bytedance.open.model.resp.BaseData

/**
 * <p> 下载账单 token 获取结果 </p>
 * <p> create 2021-08-26 10:18 by lesible </p>
 * @author 何嘉豪
 */
data class BillTokenResult(

    /**
     * 账单 token 数据
     */
    val data: BillTokenData?,

    /**
     * 错误码
     */
    override val errorCode: Int,

    /**
     * 错误码描述
     */
    override val description: String,
) : BaseData(errorCode, description)

data class BillTokenData(

    /**
     * 下载账单 token 5 分钟内有效
     */
    val billToken: String,
)