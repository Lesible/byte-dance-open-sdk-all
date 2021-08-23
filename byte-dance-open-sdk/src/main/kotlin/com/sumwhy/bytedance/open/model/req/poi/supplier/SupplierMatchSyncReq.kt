package com.sumwhy.bytedance.open.model.req.poi.supplier

/**
 * <p> 店铺匹配请求 </p>
 * <p> create 2021-08-23 13:45 by lesible </p>
 * @author 何嘉豪
 */
class SupplierMatchReq(
    val matchDataList: List<SupplierMatchData>,
)

/**
 * <p> 店铺匹配请求数据 </p>
 * <p> create 2021-08-23 13:45 by lesible </p>
 * @author 何嘉豪
 */
class SupplierMatchData private constructor(builder: Builder) {

    /**
     * POI地址
     */
    val address: String? = builder.address

    /**
     * 高德 poiId
     */
    val amapId: String? = builder.amapId

    /**
     * 高德 poiId /抖音 poiId
     */
    val poiId: String? = builder.poiId

    /**
     * POI所在城市
     */
    val city: String? = builder.city

    /**
     * 其他信息
     */
    val extra: String? = builder.extra

    /**
     * 纬度
     */
    val latitude: Double? = builder.latitude

    /**
     * 经度
     */
    val longitude: Double? = builder.longitude

    /**
     * POI名称
     */
    val poiName: String? = builder.poiName

    /**
     * POI所在省份
     */
    val province: String? = builder.province

    /**
     * 第三方商户ID
     */
    val supplierExtId: String? = builder.supplierExtId

    companion object {

        @JvmStatic
        fun builder() = Builder()

    }

    class Builder {
        var address: String? = null
        var amapId: String? = null
        var poiId: String? = null
        var city: String? = null
        var extra: String? = null
        var latitude: Double? = null
        var longitude: Double? = null
        var poiName: String? = null
        var province: String? = null
        var supplierExtId: String? = null

        fun address(address: String): Builder {
            this.address = address
            return this
        }

        fun amapId(amapId: String): Builder {
            this.amapId = amapId
            return this
        }

        fun poiId(poiId: String): Builder {
            this.poiId = poiId
            return this
        }

        fun city(city: String): Builder {
            this.city = city
            return this
        }

        fun extra(extra: String): Builder {
            this.extra = extra
            return this
        }

        fun latitude(latitude: Double): Builder {
            this.latitude = latitude
            return this
        }

        fun longitude(longitude: Double): Builder {
            this.longitude = longitude
            return this
        }

        fun poiName(poiName: String): Builder {
            this.poiName = poiName
            return this
        }

        fun province(province: String): Builder {
            this.province = province
            return this
        }

        fun supplierExtId(supplierExtId: String): Builder {
            this.supplierExtId = supplierExtId
            return this
        }

        fun build() = SupplierMatchData(this)

    }

}