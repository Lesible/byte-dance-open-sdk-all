package com.sumwhy.bytedance.open.model.universal.poi.supplier

import com.fasterxml.jackson.annotation.JsonProperty
import com.sumwhy.bytedance.open.model.universal.poi.HotelServiceFacility
import com.sumwhy.bytedance.open.model.universal.poi.supplier.enumeration.OrderTemplateEnum

/**
 * <p> 店铺属性 </p>
 * <p> create 2021-08-20 17:31 by lesible </p>
 * @author 何嘉豪
 */
class SupplierAttributes {

    /**
     * 酒店服务
     */
    @JsonProperty("1101")
    var hotelService: List<HotelServiceFacility>? = null

    /**
     * 酒店设施
     */
    @JsonProperty("1102")
    var hotelFacility: List<HotelServiceFacility>? = null

    /**
     * 酒店特色项目
     */
    @JsonProperty("1103")
    var hotelSpecialProgram: List<HotelServiceFacility>? = null

    /**
     * 酒店政策
     */
    @JsonProperty("1104")
    var hotelPolicy: List<HotelPolicy>? = null


    /**
     * 下单模板。1 - 国内模板, 2 - 海外模板
     */
    @JsonProperty("1105")
    var orderTemplate: OrderTemplateEnum? = null

    /**
     * 景区须知
     */
    @JsonProperty("3101")
    var scenicTips: ScenicTips? = null

    constructor()

    private constructor(build: Builder) {
        this.hotelService = build.hotelService
        this.hotelFacility = build.hotelFacility
        this.hotelSpecialProgram = build.hotelSpecialProgram
        this.hotelPolicy = build.hotelPolicy
        this.orderTemplate = build.orderTemplate
        this.scenicTips = build.scenicTips
    }

    companion object {

        @JvmStatic
        fun builder() = Builder()

    }

    class Builder internal constructor() {

        var hotelService: List<HotelServiceFacility>? = null

        var hotelFacility: List<HotelServiceFacility>? = null

        var hotelSpecialProgram: List<HotelServiceFacility>? = null

        var hotelPolicy: List<HotelPolicy>? = null

        var orderTemplate: OrderTemplateEnum? = null

        var scenicTips: ScenicTips? = null

        fun hotelService(hotelService: List<HotelServiceFacility>): Builder {
            this.hotelService = hotelService
            return this
        }

        fun hotelFacility(hotelFacility: List<HotelServiceFacility>): Builder {
            this.hotelFacility = hotelFacility
            return this
        }

        fun hotelSpecialProgram(hotelSpecialProgram: List<HotelServiceFacility>): Builder {
            this.hotelSpecialProgram = hotelSpecialProgram
            return this
        }

        fun hotelPolicy(hotelPolicy: List<HotelPolicy>): Builder {
            this.hotelPolicy = hotelPolicy
            return this
        }

        fun orderTemplate(orderTemplate: OrderTemplateEnum): Builder {
            this.orderTemplate = orderTemplate
            return this
        }

        fun scenicTips(scenicTips: ScenicTips): Builder {
            this.scenicTips = scenicTips
            return this
        }

        fun build() = SupplierAttributes(this)

    }
}