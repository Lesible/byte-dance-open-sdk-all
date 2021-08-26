package com.sumwhy.bytedance.open.model.universal.poi

import com.sumwhy.bytedance.open.model.universal.poi.enumeration.BreakfastTypeEnum

/**
 * <p> 早餐政策 </p>
 * <p> create by lesible at 2021-08-21 22:15</p>
 * @author 何嘉豪
 */
class Breakfast {

    /**
     * 加早费用/每人，单位人民币分 不支持加早填0
     */
    var price: Long? = null

    /**
     * 加早类型; 0 - 不支持加早; 1 - 早餐; 2 - 自助早餐
     */
    var type: BreakfastTypeEnum? = null

    constructor()

    constructor(builder: Builder) {
        this.price = builder.price
        this.type = builder.type
    }

    companion object {

        @JvmStatic
        fun builder(type: BreakfastTypeEnum) = Builder(type)

    }

    class Builder internal constructor(
        val type: BreakfastTypeEnum,
    ) {

        var price: Long? = null

        fun price(price: Long): Builder {
            this.price = price
            return this
        }

        fun build() = Breakfast(this)
    }

}
