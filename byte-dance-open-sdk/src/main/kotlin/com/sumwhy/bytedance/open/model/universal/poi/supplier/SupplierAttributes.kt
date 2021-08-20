package com.sumwhy.bytedance.open.model.universal.poi.supplier

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * <p> 店铺属性 </p>
 * <p> create 2021-08-20 17:31 by lesible </p>
 * @author 何嘉豪
 */
class SupplierAttributes {

    @JsonProperty("1101")
    val hotelService: List<HotelServiceFacility>? = null

    @JsonProperty("1102")
    val hotelFacility: List<HotelServiceFacility>? = null

    @JsonProperty("1103")
    val hotelSpecialProgram: List<HotelServiceFacility>? = null

    @JsonProperty("1104")
    val hotelPolicy: List<HotelPolicy>? = null

    @JsonProperty("1105")
    val orderTemplate: OrderTemplateEnum? = null

    @JsonProperty("3101")
    val scenicTips: ScenicTips? = null


}