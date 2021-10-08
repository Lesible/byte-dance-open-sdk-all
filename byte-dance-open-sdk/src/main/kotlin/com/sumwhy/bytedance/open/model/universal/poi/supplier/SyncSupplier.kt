package com.sumwhy.bytedance.open.model.universal.poi.supplier

import com.sumwhy.bytedance.open.model.universal.poi.enumeration.OnlineStatusEnum
import com.sumwhy.bytedance.open.model.universal.poi.supplier.enumeration.SupplierTypeEnum

/**
 * <p>  </p>
 * <p> create 2021-08-20 16:59 by lesible </p>
 * @author 何嘉豪
 */
class SyncSupplier {

    /**
     * 接入方店铺 id
     */
    var supplierExtId: String? = null

    /**
     * POI 品类编码
     */
    var typeCode: String? = null

    /**
     * 店铺地址
     */
    var address: String? = null

    /**
     * 联系手机号
     */
    var contactPhone: String? = null

    /**
     * 经度
     */
    var longitude: String? = null

    /**
     * 纬度
     */
    var latitude: String? = null

    /**
     * 推荐
     */
    var recommends: List<Recommend>? = null

    /**
     * 店铺提供的服务列表
     */
    var services: List<SupplierService>? = null

    /**
     * 在线状态
     */
    var status: OnlineStatusEnum? = null

    /**
     * 店铺类型
     */
    var type: SupplierTypeEnum? = null

    /**
     * 店铺属性字段
     */
    var attributes: SupplierAttributes? = null

    /**
     * 人均消费 (单位分)
     */
    var avgCost: Long? = null

    /**
     * 联系座机号
     */
    var contactTel: String? = null

    /**
     * 商家资质信息
     */
    var customerInfo: CustomerInfo? = null

    /**
     * 店铺名称
     */
    var name: String? = null

    /**
     * 抖音poi id, 三方如果使用高德poi id可以通过/poi/query/接口转换
     * 其它三方poi id走poi匹配功能进行抖音poi id获取
     */
    var poiId: String? = null

    /**
     * 标签
     */
    var tags: List<String>? = null

    /**
     * POI 品类描述
     * eg. 美食;中式餐饮;小龙虾
     */
    var typeName: String? = null

    /**
     * 店铺介绍(<=500字)
     */
    var description: String? = null

    /**
     * 店铺图片
     */
    var images: List<String>? = null

    /**
     * 营业时间, 从周一到周日,
     * list长度为7, 不营业则为空字符串
     */
    var openTime: List<String>? = null

    constructor()

    private constructor(builder: Builder) : this() {
        this.supplierExtId = builder.supplierExtId
        this.typeCode = builder.typeCode
        this.address = builder.address
        this.contactPhone = builder.contactPhone
        this.longitude = builder.longitude
        this.latitude = builder.latitude
        this.recommends = builder.recommends
        this.services = builder.services
        this.status = builder.status
        this.type = builder.type
        this.attributes = builder.attributes
        this.avgCost = builder.avgCost
        this.contactTel = builder.contactTel
        this.name = builder.name
        this.poiId = builder.poiId
        this.tags = builder.tags
        this.typeName = builder.typeName
        this.description = builder.description
        this.images = builder.images
        this.openTime = builder.openTime
        this.customerInfo = builder.customerInfo
    }

    companion object {

        @JvmStatic
        fun builder(
            supplierExtId: String, status: OnlineStatusEnum, type: SupplierTypeEnum,
            attributes: SupplierAttributes, name: String, poiId: String,
        ) =
            Builder(supplierExtId, status, type, attributes, name, poiId)
    }

    class Builder(
        val supplierExtId: String,
        val status: OnlineStatusEnum,
        val type: SupplierTypeEnum,
        val attributes: SupplierAttributes,
        val name: String,
        val poiId: String,
    ) {
        var typeCode: String? = null
        var address: String? = null
        var contactPhone: String? = null
        var longitude: String? = null
        var recommends: List<Recommend>? = null
        var services: List<SupplierService>? = null
        var avgCost: Long? = null
        var latitude: String? = null
        var contactTel: String? = null
        var tags: List<String>? = null
        var typeName: String? = null
        var description: String? = null
        var images: List<String>? = null
        var openTime: List<String>? = null
        var customerInfo: CustomerInfo? = null

        fun typeCode(typeCode: String): Builder {
            this.typeCode = typeCode
            return this
        }

        fun address(address: String): Builder {
            this.address = address
            return this
        }

        fun contactPhone(contactPhone: String): Builder {
            this.contactPhone = contactPhone
            return this
        }

        fun longitude(longitude: String): Builder {
            this.longitude = longitude
            return this
        }

        fun recommends(recommends: List<Recommend>): Builder {
            this.recommends = recommends
            return this
        }

        fun services(services: List<SupplierService>): Builder {
            this.services = services
            return this
        }

        fun avgCost(avgCost: Long): Builder {
            this.avgCost = avgCost
            return this
        }

        fun latitude(latitude: String): Builder {
            this.latitude = latitude
            return this
        }

        fun contactTel(contactTel: String): Builder {
            this.contactTel = contactTel
            return this
        }

        fun tags(tags: List<String>): Builder {
            this.tags = tags
            return this
        }

        fun typeName(typeName: String): Builder {
            this.typeName = typeName
            return this
        }

        fun description(description: String): Builder {
            this.description = description
            return this
        }

        fun images(images: List<String>): Builder {
            this.images = images
            return this
        }

        fun openTime(openTime: List<String>): Builder {
            this.openTime = openTime
            return this
        }

        fun customerInfo(customerInfo: CustomerInfo): Builder {
            this.customerInfo = customerInfo
            return this
        }

        fun build() = SyncSupplier(this)
    }
}
