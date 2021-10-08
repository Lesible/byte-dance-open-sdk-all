package com.sumwhy.bytedance.open.model.universal.poi.supplier

/**
 * <p> 商家资质信息 </p>
 * <p> create 2021-09-30 09:47 by lesible </p>
 * @author 何嘉豪
 */
class CustomerInfo constructor(builder: Builder) {

    /**
     * 商家营业执照
     */
    val businessLicense = builder.businessLicense

    /**
     * 行业许可证
     */
    val industryLicense = builder.industryLicense

    /**
     * 其他补充材料
     */
    val otherInfo = builder.otherInfo

    /**
     * 服务商和商家合作协议/授意书
     */
    val powerOfAttorney = builder.powerOfAttorney

    companion object {

        @JvmStatic
        fun builder(
            businessLicense: CompanyExtInfo,
            powerOfAttorney: ExtInfo,
            industryLicense: List<ExtInfo>,
        ) =
            Builder(businessLicense, powerOfAttorney, industryLicense)

    }

    class Builder internal constructor(
        val businessLicense: CompanyExtInfo,
        val powerOfAttorney: ExtInfo,
        val industryLicense: List<ExtInfo>,
    ) {

        var otherInfo: List<ExtInfo>? = null

        fun otherInfo(otherInfo: List<ExtInfo>): Builder {
            this.otherInfo = otherInfo
            return this
        }

        fun build() = CustomerInfo(this)

    }

}


open class ExtInfo(

    open val extId: String,

    open val url: String,
)

class CompanyExtInfo(val company: String, override val extId: String, override val url: String) : ExtInfo(extId, url)