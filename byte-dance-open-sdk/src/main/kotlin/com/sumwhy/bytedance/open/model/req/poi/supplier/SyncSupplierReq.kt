package com.sumwhy.bytedance.open.model.req.poi.supplier

import com.sumwhy.bytedance.open.model.universal.poi.supplier.Recommend
import com.sumwhy.bytedance.open.model.universal.poi.supplier.SupplierAttributes
import com.sumwhy.bytedance.open.model.universal.poi.supplier.SupplierService
import com.sumwhy.bytedance.open.model.universal.poi.supplier.enumeration.OnlineStatusEnum
import com.sumwhy.bytedance.open.model.universal.poi.supplier.enumeration.SupplierTypeEnum

/**
 * <p>  </p>
 * <p> create 2021-08-20 16:59 by lesible </p>
 * @author 何嘉豪
 */
class SyncSupplierReq private constructor(builder: Builder) {

    /**
     * 接入方店铺 id
     */
    val supplierExtId = builder.supplierExtId

    /**
     * POI 品类编码
     */
    val typeCode = builder.typeCode

    /**
     * 店铺地址
     */
    val address = builder.address

    /**
     * 联系手机号
     */
    val contactPhone = builder.contactPhone

    /**
     * 经度
     */
    val longitude = builder.longitude

    /**
     * 纬度
     */
    val latitude = builder.latitude

    /**
     * 推荐
     */
    val recommends = builder.recommends

    /**
     * 店铺提供的服务列表
     */
    val services = builder.services

    /**
     * 在线状态
     */
    val status = builder.status

    /**
     * 店铺类型
     */
    val type = builder.type

    /**
     * 店铺属性字段
     */
    val attributes = builder.attributes

    /**
     * 人均消费 (单位分)
     */
    val avgCost = builder.avgCost

    /**
     * 联系座机号
     */
    val contactTel = builder.contactTel

    /**
     * 店铺名称
     */
    val name = builder.name

    /**
     * 抖音poi id, 三方如果使用高德poi id可以通过/poi/query/接口转换
     * 其它三方poi id走poi匹配功能进行抖音poi id获取
     */
    val poiId = builder.poiId

    /**
     * 标签
     */
    val tags = builder.tags

    /**
     * POI 品类描述
     * eg. 美食;中式餐饮;小龙虾
     */
    val typeName = builder.typeName

    /**
     * 店铺介绍(<=500字)
     */
    val description = builder.description

    /**
     * 店铺图片
     */
    val images = builder.images

    /**
     * 营业时间, 从周一到周日,
     * list长度为7, 不营业则为空字符串
     */
    val openTime = builder.openTime

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


        fun build() = SyncSupplierReq(this)
    }
}
