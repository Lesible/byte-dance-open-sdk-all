package com.sumwhy.bytedance.open.model.universal.poi

/**
 * <p> 酒店服务设施 </p>
 * <p> create 2021-08-20 17:33 by lesible </p>
 * @author 何嘉豪
 */
class HotelServiceFacility {

    /**
     * 设施/服务code
     * <p>
     * -1代表自定义。1 - 空调; 2 - 电视; 3 - 阳台; 4 - 窗户;
     * 5 - 独立卫浴; 6 - 浴缸; 7 - 吹风机; 8 - 衣架; 9 - 热水;
     * 10 - 洗衣机; 11 - 基本厨具; 12 - 冰箱; 13 - 免费Wifi;
     * 14 - 电热水壶; 15 - 暖气; 16 - 智能马桶; 17 - 微波炉;
     * 18 - 门禁系统; 19 - 智能门锁; 20 - 私家花园;
     * 21 - 私家泳池; 22 - 观景露台; 23 - 免费停车; 24 - 行李寄存;
     */
    var code: Int? = null

    /**
     * 设施/服务名称, code与name不匹配时，code生效。自定义项目不超过5个汉字
     */
    var name: String? = null

    constructor()

    private constructor(builder: Builder) {
        this.code = builder.code
        this.name = builder.name
    }

    companion object {

        @JvmStatic
        fun builder(code: Int) = Builder(code)

    }

    class Builder internal constructor(
        val code: Int,
    ) {
        var name: String? = null

        fun name(name: String): Builder {
            this.name = name
            return this
        }

        fun build() = HotelServiceFacility(this)
    }

}