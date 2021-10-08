package com.sumwhy.bytedance.open.model.req.poi.product

import com.fasterxml.jackson.annotation.JsonProperty
import com.sumwhy.bytedance.open.model.universal.poi.product.SpuAttribute
import com.sumwhy.bytedance.open.model.universal.poi.supplier.EntryMiniApp
import com.sumwhy.bytedance.open.model.universal.poi.supplier.enumeration.EntryTypeEnum

/**
 * <p>  </p>
 * <p> create 2021-08-26 11:08 by lesible </p>
 * @author 何嘉豪
 */
class SpuSyncReq private constructor(builder: Builder) {

    /**
     * 商品亮点标签
     */
    val highlights = builder.highlights

    /**
     * 商品名
     */
    val name = builder.name

    /**
     * 接入方商品ID
     */
    val spuExtId = builder.spuExtId

    /**
     * SPU状态，
     */
    val status = builder.status

    /**
     * 价格，单位分
     */
    val price = builder.price

    /**
     * 推荐语，5~20个字
     */
    val recommendWord = builder.recommendWord

    /**
     * 库存
     */
    val stock = builder.stock

    /**
     * 商品的抽佣率，万分数
     */
    val takeRate = builder.takeRate

    /**
     * 入口信息
     */
    val entryInfo = builder.entryInfo

    /**
     * SPU图片，预售券必传
     */
    val imageList = builder.imageList

    /**
     * 排序权重，按降序排列
     */
    val sortWeight = builder.sortWeight

    /**
     * spu类型号，1-日历房，30-酒店民宿预售券，90-门票，91-团购券
     */
    val spuType = builder.spuType

    /**
     * SPU属性字段
     */
    val attribute = builder.attribute

    /**
     * 前台品类标签
     */
    val frontCategoryTag = builder.frontCategoryTag

    /**
     * (暂时不对外开放)下单是否依赖日期
     */
    val orderDependsOnDate = builder.orderDependsOnDate

    /**
     * 价格，单位分
     */
    val originPrice = builder.originPrice


    /**
     * 接入方店铺ID列表
     */
    val supplierExtIdList = builder.supplierExtIdList

    companion object {

        @JvmStatic
        fun builder(
            name: String,
            spuExtId: String,
            status: Int,
            price: Int,
            stock: Int,
            imageList: List<String>,
            spuType: Int,
            attribute: SpuAttribute,
            originPrice: Int,
            supplierExtIdList: List<String>,
        ) = Builder(
            name,
            spuExtId,
            status,
            price,
            stock,
            imageList,
            spuType,
            attribute,
            originPrice,
            supplierExtIdList
        )

    }

    class Builder(
        val name: String,
        val spuExtId: String,
        val status: Int,
        val price: Int,
        val stock: Int,
        val imageList: List<String>,
        val spuType: Int,
        val attribute: SpuAttribute,
        val originPrice: Int,
        val supplierExtIdList: List<String>,
    ) {
        var highlights: List<Highlight>? = null
        var recommendWord: String? = null
        var takeRate: Int? = null
        var entryInfo: EntryInfo? = null
        var sortWeight: Int? = null
        var frontCategoryTag: List<String>? = null
        var orderDependsOnDate: Boolean? = null

        fun highlights(highlights: List<Highlight>): Builder {
            this.highlights = highlights
            return this
        }

        fun recommendWord(recommendWord: String): Builder {
            this.recommendWord = recommendWord
            return this
        }

        fun takeRate(takeRate: Int): Builder {
            this.takeRate = takeRate
            return this
        }

        fun entryInfo(entryInfo: EntryInfo): Builder {
            this.entryInfo = entryInfo
            return this
        }

        fun sortWeight(sortWeight: Int): Builder {
            this.sortWeight = sortWeight
            return this
        }

        fun frontCategoryTag(frontCategoryTag: List<String>): Builder {
            this.frontCategoryTag = frontCategoryTag
            return this
        }

        fun orderDependsOnDate(orderDependsOnDate: Boolean): Builder {
            this.orderDependsOnDate = orderDependsOnDate
            return this
        }

        fun build() = SpuSyncReq(this)
    }
}

class EntryInfo(
    /**
     * 小程序入口参数
     */
    @field:JsonProperty("entry_miniApp")
    val entryMiniApp: EntryMiniApp,

    /**
     * 入口类型(1:H5，2:抖音小程序，3:抖音链接)
     */
    val entryType: EntryTypeEnum,


    /**
     * 入口链接
     */
    val entryUrl: String,
)

class Highlight(

    /**
     * 介绍，字符串长度<=5
     */
    val content: String?,

    /**
     * 优先级，数字越小优先级越高
     */
    val priority: Int?,
)
