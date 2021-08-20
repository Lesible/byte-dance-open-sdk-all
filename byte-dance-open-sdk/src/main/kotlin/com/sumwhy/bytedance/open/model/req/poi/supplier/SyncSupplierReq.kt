package com.sumwhy.bytedance.open.model.req.poi.supplier

import com.sumwhy.bytedance.open.model.universal.poi.supplier.SupplierAttributes

/**
 * <p>  </p>
 * <p> create 2021-08-20 16:59 by lesible </p>
 * @author 何嘉豪
 */
class SyncSupplierReq private constructor(builder: Builder) {

    private val supplierExtId = builder.supplierExtId
    private val typeCode = builder.typeCode
    private val address = builder.address
    private val contactPhone = builder.contactPhone
    private val longitude = builder.longitude
    private val recommends = builder.recommends
    private val services = builder.services
    private val status = builder.status
    private val type = builder.type
    private val attributes = builder.attributes
    private val avgCost = builder.avgCost
    private val latitude = builder.latitude
    private val contactTel = builder.contactTel
    private val name = builder.name
    private val poiId = builder.poiId
    private val tags = builder.tags
    private val typeName = builder.typeName
    private val description = builder.description
    private val images = builder.images
    private val openTime = builder.openTime

    companion object {

        /**
         * 在线状态
         */
        const val ONLINE_STATUS = 1

        /**
         * 下线状态
         */
        const val OFFLINE_STATUS = 2

        /**
         * 酒店民宿
         */
        const val SUPPLIER_TYPE_HOTEL = 1

        /**
         * 餐饮
         */
        const val SUPPLIER_TYPE_FOOD = 2

        /**
         * 景区
         */
        const val SUPPLIER_TYPE_SCENIC = 3

        @JvmStatic
        fun builder(
            supplierExtId: String, status: Int, type: Int,
            attributes: SupplierAttributes, name: String, poiId: Long,
        ) =
            Builder(supplierExtId, status, type, attributes, name, poiId)
    }

    class Builder(
        val supplierExtId: String,
        val status: Int,
        val type: Int,
        val attributes: SupplierAttributes,
        val name: String,
        val poiId: Long,
    ) {
        var typeCode: String? = null
        var address: String? = null
        var contactPhone: String? = null
        var longitude: String? = null
        var recommends: String? = null
        var services: String? = null
        var avgCost: String? = null
        var latitude: String? = null
        var contactTel: String? = null
        var tags: String? = null
        var typeName: String? = null
        var description: String? = null
        var images: String? = null
        var openTime: String? = null

        fun build() = SyncSupplierReq(this)
    }
}
