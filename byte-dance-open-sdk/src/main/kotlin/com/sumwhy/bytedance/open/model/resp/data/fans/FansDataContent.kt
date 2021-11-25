package com.sumwhy.bytedance.open.model.resp.data.fans

import com.sumwhy.bytedance.open.model.resp.BaseData

/**
 * <p>  </p>
 * <p> created at 2021-11-25 15:09 by lesible </p>
 * @author 何嘉豪
 */
data class FansDataRet(

    /**
     * 粉丝数据
     */
    val fansData: FansData,

    /**
     * 错误码
     */
    override val errorCode: Int,

    /**
     * 错误码描述
     */
    override val description: String,
) : BaseData(errorCode, description)

data class FansData(
    /**
     * 粉丝活跃天数分布
     */
    val activeDaysDistributions: List<Any>?,

    /**
     * 粉丝年龄分布
     */
    val ageDistributions: List<Any>?,

    /**
     * 所有粉丝的数量
     */
    val allFansNum: Int?,

    /**
     * 粉丝设备分布
     */
    val deviceDistributions: List<Any>?,

    /**
     * 粉丝流量贡献
     */
    val flowContributions: List<FlowContribution>?,

    /**
     * 粉丝性别分布
     */
    val genderDistributions: List<Distribution>?,

    /**
     * 粉丝地域分布
     */
    val geographicalDistributions: List<Distribution>?,

    /**
     * 粉丝兴趣分布
     */
    val interestDistributions: List<Distribution>?,
)

data class Distribution(
    /**
     * 分布的种类
     */
    val item: String?,

    /**
     * 分布的数值
     */
    val value: Int?,
)

data class FlowContribution(
    val fansSum: Int,
    val allSum: Int,
    val flow: String,
)
