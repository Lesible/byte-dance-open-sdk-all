package com.sumwhy.bytedance.open.model.resp.poi.product

import com.sumwhy.bytedance.open.model.req.poi.product.EntryInfo
import com.sumwhy.bytedance.open.model.req.poi.product.Highlight
import com.sumwhy.bytedance.open.model.resp.BaseData
import com.sumwhy.bytedance.open.model.universal.poi.product.SpuAttribute

/**
 *
 * <p> 商品 spu 同步结果  </p>
 * @author 何嘉豪
 */
data class SpuInfoSyncResult(

    /**
     * spu 详情
     */
    val spuDetail: SpuDetail?,

    /**
     * 状态同步成功的 spuExtId 列表
     */
    val spuDraft: List<SpuDraft>?,

    /**
     * 错误码
     */
    override val errorCode: Int,

    /**
     * 错误码描述
     */
    override val description: String,
) : BaseData(errorCode, description)

data class SpuDraft(

    /**
     * 商品亮点标签
     */
    val highlights: List<Highlight>?,

    /**
     * 价格，单位分
     */
    val price: Int?,

    /**
     * 接入方商品ID
     */
    val spuExtId: String?,

    /**
     * SPU属性字段
     */
    val attribute: SpuAttribute?,

    /**
     * 入口信息
     */
    val entryInfo: EntryInfo?,

    /**
     * 前台品类标签
     */
    val frontCategoryTag: List<String>?,

    /**
     * SPU图片，预售券必传
     */
    val imageList: List<String>?,

    /**
     *
     */
    val spuFilterStatus: List<SpuFilterStatus>?,

    /**
     * spu_id
     */
    val spuId: Int?,

    /**
     * 状态：0-审核中，1-上架，2-下架，3-审核拒绝
     */
    val status: Int?,

    /**
     * 商品名
     */
    val name: String?,

    /**
     * spu类型号，1-日历房，30-酒店民宿预售券，90-门票，91-团购券
     */
    val spuType: Int?,

    /**
     * 价格，单位分
     */
    val originPrice: Int?,

    /**
     * 排序权重，按降序排列
     */
    val sortWeight: Int?,

    /**
     * 状态描述
     */
    val statusDesc: String?,

    /**
     * 库存
     */
    val stock: Int?,

    /**
     * 接入方店铺ID列表
     */
    val supplierExtIdList: List<String>?,


    /**
     * 商品的抽佣率，万分数
     */
    val takeRate: Int?,


    )

class SpuFilterStatus(

    /**
     * 过滤规则
     */
    val spuPoiFilterStatus: List<SpuPoiFilterStatus>?,

    /**
     * 供应商Id
     */
    val supplierId: String?,

    )

data class SpuPoiFilterStatus(

    /**
     * supplier下的poiId
     */
    var poiId: String?,

    /**
     * 过滤原因
     */
    var reason: String?,

    /**
     * 过滤码
     */
    var code: Int?,


    /**
     * 是否被过滤
     */
    var filter: Boolean?,

    )

data class SpuDetail(

    /**
     * 商品亮点标签
     */
    val highlights: List<Any>?,

    /**
     * 价格，单位分
     */
    val price: Int?,

    /**
     * 接入方商品ID
     */
    val spuExtId: String?,

    /**
     * SPU属性字段
     */
    val attribute: Any?,

    /**
     * 入口信息
     */
    val entryInfo: Any?,

    /**
     * 前台品类标签
     */
    val frontCategoryTag: List<Any>?,

    /**
     * SPU图片，预售券必传
     */
    val imageList: List<Any>?,

    /**
     *
     */
    val spuFilterStatus: List<Any>?,

    /**
     * spu_id
     */
    val spuId: Int?,

    /**
     * 状态：0-审核中，1-上架，2-下架，3-审核拒绝
     */
    val status: Int?,

    /**
     * 商品名
     */
    val name: String?,

    /**
     * spu类型号，1-日历房，30-酒店民宿预售券，90-门票，91-团购券
     */
    val spuType: Int?,

    /**
     * 价格，单位分
     */
    val originPrice: Int?,

    /**
     * 排序权重，按降序排列
     */
    val sortWeight: Int?,

    /**
     * 状态描述
     */
    val statusDesc: String?,

    /**
     * 库存
     */
    val stock: Int?,

    /**
     * 接入方店铺ID列表
     */
    val supplierExtIdList: List<Any>?,


    /**
     * 商品的抽佣率，万分数
     */
    val takeRate: Int?,
)