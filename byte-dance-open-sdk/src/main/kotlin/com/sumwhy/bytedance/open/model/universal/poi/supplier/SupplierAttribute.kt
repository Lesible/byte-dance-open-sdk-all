package com.sumwhy.bytedance.open.model.universal.poi.supplier

import com.sumwhy.bytedance.open.model.universal.poi.Breakfast
import com.sumwhy.bytedance.open.model.universal.poi.supplier.enumeration.NodeTypeEnum

/**
 * <p> 酒店政策  </p>
 * <p> create 2021-08-20 17:33 by lesible </p>
 * @author 何嘉豪
 */
class HotelPolicy {

    /**
     * 早餐政策
     */
    var breakfast: Breakfast? = null

    /**
     * 入住时间(HH:mm)
     */
    var checkInTime: String? = null

    /**
     * 离店时间(HH:mm)
     */
    var checkOutTime: String? = null

    /**
     * 儿童政策(<=500字)
     */
    var child: String? = null

    /**
     * 宠物政策(<=500字)
     */
    var pet: String? = null

    constructor()

    constructor(builder: Builder) {
        this.breakfast = builder.breakfast
        this.checkInTime = builder.checkInTime
        this.checkOutTime = builder.checkOutTime
        this.child = builder.child
        this.pet = builder.pet
    }

    companion object {

        @JvmStatic
        fun builder() = Builder()

    }

    class Builder internal constructor() {
        var breakfast: Breakfast? = null
        var checkInTime: String? = null
        var checkOutTime: String? = null
        var child: String? = null
        var pet: String? = null

        fun breakfast(breakfast: Breakfast): Builder {
            this.breakfast = breakfast
            return this
        }

        fun checkInTime(checkInTime: String): Builder {
            this.checkInTime = checkInTime
            return this
        }

        fun checkOutTime(checkOutTime: String): Builder {
            this.checkOutTime = checkOutTime
            return this
        }

        fun child(child: String): Builder {
            this.child = child
            return this
        }

        fun pet(pet: String): Builder {
            this.pet = pet
            return this
        }

        fun build() = HotelPolicy(this)

    }

}

/**
 * <p> 景区须知  </p>
 * <p> create 2021-08-20 17:33 by lesible </p>
 * @author 何嘉豪
 */
class ScenicTips {

    /**
     * 开放时间
     */
    var openTime: String? = null

    /**
     * 开放时间-扩展区(不超过200个汉字)
     */
    var openTimeExt: List<ExtContent>? = null

    /**
     * 优待政策-扩展区(不超过1000个汉字)
     */
    var preferentialPolicyExt: List<ExtContent>? = null

    /**
     * 交通(不超过200个汉字)
     */
    var traffic: List<ExtContent>? = null

    /**
     * 服务设施列表
     */
    var facility: List<ScenicFacility>? = null

    /**
     * 宠物携带(1:可携带宠物，2:不可携带宠物)
     */
    var pet: Int? = null

    /**
     * 玩法介绍(不超过200个汉字)
     */
    var playIntro: List<ExtContent>? = null

    /**
     * 优待政策(不超过200个汉字)
     */
    var preferentialPolicy: List<ExtContent>? = null

    /**
     * 景点介绍(不超过2000个汉字)
     */
    var scenicIntro: List<ExtContent>? = null

    constructor()

    private constructor(builder: Builder) {
        this.openTime = builder.openTime
        this.openTimeExt = builder.openTimeExt
        this.preferentialPolicyExt = builder.preferentialPolicyExt
        this.traffic = builder.traffic
        this.facility = builder.facility
        this.pet = builder.pet
        this.playIntro = builder.playIntro
        this.preferentialPolicy = builder.preferentialPolicy
        this.scenicIntro = builder.scenicIntro
    }

    companion object {

        @JvmStatic
        fun builder() = Builder()

    }

    class Builder internal constructor() {
        var openTime: String? = null
        var openTimeExt: List<ExtContent>? = null
        var preferentialPolicyExt: List<ExtContent>? = null
        var traffic: List<ExtContent>? = null
        var facility: List<ScenicFacility>? = null
        var pet: Int? = null
        var playIntro: List<ExtContent>? = null
        var preferentialPolicy: List<ExtContent>? = null
        var scenicIntro: List<ExtContent>? = null

        fun openTime(openTime: String): Builder {
            this.openTime = openTime
            return this
        }

        fun openTimeExt(openTimeExt: List<ExtContent>): Builder {
            this.openTimeExt = openTimeExt
            return this
        }

        fun preferentialPolicyExt(preferentialPolicyExt: List<ExtContent>): Builder {
            this.preferentialPolicyExt = preferentialPolicyExt
            return this
        }

        fun traffic(traffic: List<ExtContent>): Builder {
            this.traffic = traffic
            return this
        }

        fun facility(facility: List<ScenicFacility>): Builder {
            this.facility = facility
            return this
        }

        fun pet(pet: Int): Builder {
            this.pet = pet
            return this
        }

        fun playIntro(playIntro: List<ExtContent>): Builder {
            this.playIntro = playIntro
            return this
        }

        fun preferentialPolicy(preferentialPolicy: List<ExtContent>): Builder {
            this.preferentialPolicy = preferentialPolicy
            return this
        }

        fun scenicIntro(scenicIntro: List<ExtContent>): Builder {
            this.scenicIntro = scenicIntro
            return this
        }

        fun build() = ScenicTips(this)

    }

}

/**
 * <p> 扩展内容  </p>
 * <p> create 2021-08-20 22:54 by lesible </p>
 * @author 何嘉豪
 */
class ExtContent {

    /**
     * 节点内容
     */
    var content: String? = null

    /**
     * 富文本处理中的节点类型 1 - text 2 - image
     */
    var nodeType: NodeTypeEnum? = null

    constructor()

    constructor(content: String?, nodeType: NodeTypeEnum?) {
        this.content = content
        this.nodeType = nodeType
    }
}

/**
 * <p> 景区设施  </p>
 * <p> create 2021-08-20 23:09 by lesible </p>
 * @author 何嘉豪
 */
class ScenicFacility {

    var name: String? = null

    constructor()

    constructor(name: String?) {
        this.name = name
    }


}