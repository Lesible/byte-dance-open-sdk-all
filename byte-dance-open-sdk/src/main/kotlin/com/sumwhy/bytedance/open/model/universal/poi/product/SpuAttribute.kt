package com.sumwhy.bytedance.open.model.universal.poi.product

import com.fasterxml.jackson.annotation.JsonProperty
import com.sumwhy.bytedance.open.model.universal.poi.Breakfast
import com.sumwhy.bytedance.open.model.universal.poi.HotelServiceFacility

/**
 * <p>  </p>
 * <p> create 2021-08-26 16:48 by lesible </p>
 * @author 何嘉豪
 */
class SpuAttribute {

    /**
     * 日历房商品结构
     */
    @JsonProperty("101")
    var calendarHouse: CalendarHouse? = null

    /**
     * 预约券商品结构
     */
    @JsonProperty("3001")
    var presaleCoupon: PresaleCoupon? = null

    /**
     * 门票商品结构
     */
    @JsonProperty("9001")
    var ticket: Ticket? = null

    @JsonProperty("9101")
    var grouponProduct: GrouponProduct? = null


}

class GrouponProduct {

    /**
     * 单个用户购买数量限制
     */
    var orderLimit: Int? = null

    /**
     * 商家联系人姓名
     */
    var contactName: String? = null

    /**
     * 富文本格式的商品介绍，最大不超过5mb
     */
    var descriptionRichText: String? = null

    /**
     * 商家名称
     */
    var merchantName: String? = null

    /**
     *
     */
    var notification: List<Notification>? = null

    /**
     * 副标题，可选标题：过期退、随时退、x日内可退，x>=3、免预约、提前x日预约，x>=1，多个以
     */
    var subTitle: String? = null

    /**
     * 使用日期规则
     */
    var dateRule: DateRule? = null

    /**
     * 团购售卖时间结束
     */
    var grouponValidEnd: String? = null

    /**
     * 团购详情
     */
    var payItemGroups: List<PayItemGroup>? = null

    /**
     * 购买后xxx天内可使用，与order_valid_start&order_valid_end
     */
    var postPurchaseDay: Int? = null

    /**
     * (暂时不对外开放)票种类型
     */
    var ticketType: Int? = null

    /**
     * 富文本格式的购买须知，最大不超过5mb
     */
    var notificationRichText: String? = null

    /**
     * 券有效期开始
     */
    var orderValidStart: String? = null

    /**
     * 商家客服电话，最多传3个
     */
    var servicePhone: List<String>? = null

    /**
     * (暂时不对外开放)适用人群
     */
    var suitableGroup: Int? = null

    /**
     * 团购售卖时间开始
     */
    var grouponValidStart: String? = null


}

class Ticket {

    /**
     * 是否立即确认
     */
    @JsonProperty("is_confirm_imme")
    var confirmImmediately: Boolean? = null

    /**
     * 是否需要取票
     */
    var isNeedPick: Boolean? = null

    /**
     * 从当前时刻看，最早能被订到的门票时间
     */
    var nearestOrderTime: NearestOrderTime? = null

    /**
     * 是否可退
     */
    var refundPolicy: Int? = null

    /**
     * (暂时不对外开放)适用人群
     */
    var suitableGroup: Int? = null


    /**
     * (暂时不对外开放)票种类型
     */
    var ticketType: Int? = null

}

class NearestOrderTime {

    /**
     * time_type为3时该字段必选(yyyyMMdd格式)，time_type为4时该字段必选(HH:mm格式),
     */
    var time: String? = null


    /**
     * 时间格式 1-最早可订今日，2-最早可订明日, 3-最早可订MM月dd日, 4-HH:mm前可订当日, 5-需提前x天预订
     */
    var timeType: Int? = null

}

class PresaleCoupon {

    /**
     * 加早规则
     */
    var breakfastRule: BreakfastRule? = null

    /**
     * 使用日期规则
     */
    var dateRule: DateRule? = null

    /**
     * 预售有效期开始
     */
    var grouponValidStart: String? = null

    /**
     * 使用须知
     */
    var notification: List<Notification>? = null

    /**
     * 订单（券码）有效期开始
     */
    var orderValidStart: String? = null

    /**
     * 服务电话，最多传3个
     */
    var servicePhone: List<String>? = null

    /**
     * 服务电话信息
     */
    var servicePhoneInfo: ServicePhoneInfo? = null

    /**
     * 入离店时间
     */
    var checkRule: String? = null

    /**
     * 预售券图文详情
     */
    var grouponDetail: List<GrouponDetail>? = null

    /**
     * 预售有效期结束
     */
    var grouponValidEnd: String? = null

    /**
     * 携带宠物规则
     */
    var petRule: String? = null

    /**
     * 加床规则
     */
    var addBedRule: AddBedRule? = null

    /**
     * 商品组
     */
    var productGroup: List<ProductGroup>? = null

    /**
     * 预约信息
     */
    var appointmentInfo: AppointmentInfo? = null

    /**
     * 到达方式
     */
    var arriveRule: String? = null

    /**
     * 单个用户购买数量限制
     */
    var orderLimit: Int? = null

    /**
     * 订单（券码）有效期结束
     */
    var orderValidEnd: String? = null

    /**
     * (暂时不对外开放)适用人群
     */
    var suitableGroup: Int? = null


    /**
     * (暂时不对外开放)票种类型
     */
    var ticketType: Int? = null


}

class AppointmentInfo {

    /**
     * 预约补充说明,最多500字
     */
    var appointmentDetail: String? = null

    /**
     * 电话预约信息，appointment_type=1时必填
     */
    var appointmentPhoneInfo: ServicePhoneInfo? = null

    /**
     * 预约方式：1-电话，2-在线
     */
    var appointmentType: Int? = null

    /**
     * 外部预约链接
     */
    var appointmentUrl: String? = null

    /**
     * 是否需要提前预约,1-是，0-否
     */
    var needAppointment: Int? = null

    /**
     * 查看订单预约结果链接，入口会在后面拼上券码和openId
     */
    var orderAppointmentDetailUrl: String? = null


    /**
     * 提前多少天预约，need_appointment=1时必传
     */
    var appointmentDays: Int? = null

}

class ProductGroup {

    /**
     * 代金券，product_group_type=5时必传
     */
    var cashCoupon: CashCoupon? = null

    /**
     * 客房信息，product_group_type=1时必传
     */
    var guestRoom: GuestRoom? = null

    /**
     * 商品内容，product_group_type=2，3，4，6时必填
     */
    var productGroupContent: List<ProductGroupContent>? = null


    /**
     * 商品组类型:1-客房；2-餐饮；3-景区门票；4-休闲娱乐；5-代金券；6-其他
     */
    var productGroupType: Int? = null

}

class ProductGroupContent {

    /**
     * 内容
     */
    var content: String? = null


    /**
     * 数量
     */
    var num: Int? = null

}

class GuestRoom {

    /**
     * 入住人数
     */
    var guestNum: Int? = null

    /**
     * 是否含早
     */
    var hasBreakfast: Boolean? = null

    /**
     * 适用房型信息
     */
    var roomDetail: String? = null

    /**
     * 房间数量
     */
    var roomNum: Int? = null


    /**
     * 入住天数
     */
    var stayNum: Int? = null

}

class CashCoupon {

    /**
     * 商品内容,文本，最多20字
     */
    var couponContent: String? = null

    /**
     * 商品数量
     */
    var couponNum: Int? = null


    /**
     * 适用范围，文本，最多100字
     */
    var coverage: String? = null

}

class AddBedRule {

    /**
     * 加床规则，文本，最多200个字
     */
    var addBedRule: String? = null

    /**
     * 是否支持加床
     */
    var canAddBed: Boolean? = null

}

class GrouponDetail {

    /**
     * 内容
     */
    var content: String? = null

    /**
     * 类型，1-图片，2-文字
     */
    var type: Int? = null

}

class ServicePhoneInfo {

    /**
     * 不同门店不同服务电话：和商品适用门店数保持一致;key-supplier_ext_id,value-电话列表
     * {"supplier_ext_id1":["123456","123456"]}
     */
    var shopPhone: String? = null

    /**
     * 多门店统一服务电话：最多三个
     */
    var unifiedPhone: List<String>? = null

}

class Notification(
    /**
     * 使用须知
     */
    var title: String?,
    /**
     * 内容
     */
    var content: String?,
) {
    constructor() : this(null, null)
}


class DateRule {

    /**
     * 加价可用日期
     * 与 unavailable_date 不可重复
     */
    var increasePriceDate: IncreasePriceDate? = null

    /**
     * 不可用日期
     */
    var unavailableDate: UnavailableDate? = null

}

class UnavailableDate {

    /**
     * 星期列表，1-7代表周一到周天，[1,2]代表周一周二不可用
     */
    var weekdayList: List<Int>? = null


    /**
     * 日期列表，格式yyyy-mm-dd，最多传100个
     */
    var dateList: List<String>? = null

}

class IncreasePriceDate {

    /**
     * 日期列表，格式yyyy-mm-dd，最多传100个
     */
    var dateList: List<String>? = null

    /**
     * 加价规则，最多1000字
     */
    var increasePriceRule: String? = null

    /**
     * 星期列表，1-7代表周一到周天，[1,2]代表周一周二不可用
     */
    var weekdayList: List<Int>? = null

}

class BreakfastRule {

    /**
     * 加早规则
     */
    var addBreakfastRule: String? = null


    /**
     * 是否支持加早
     */
    var canAddBreakfast: Boolean? = null
}

class CalendarHouse {

    /**
     * 可住人数
     */
    var fitNum: Int? = null

    /**
     * 是否禁烟
     */
    var smoke: String? = null

    /**
     * 出行提示
     */
    var travelTips: TravelTips? = null

    /**
     * 是否有窗户
     */
    var window: String? = null

    /**
     * 床型名称
     */
    var bedName: String? = null

    /**
     * 费用政策
     */
    var expense: ExpensePolicy? = null

    /**
     * 早餐;
     */
    var breakfast: Int? = null

    /**
     * 服务设施
     */
    var facility: List<HotelServiceFacility>? = null

    /**
     * 楼层
     */
    var floor: Floor? = null

    /**
     * 景观
     */
    var view: String? = null

    /**
     * 免费
     */
    var wifi: String? = null

    /**
     * 退改政策
     */
    var amend: AmendPolicy? = null

    /**
     * 面积（平方米）
     */
    var area: Int? = null

}

/**
 * 出行提示
 */
class TravelTips {
    /**
     * 入住时间 (HH:mm)
     */
    val checkInTime: String? = null

    /**
     * 离店时间 (HH:mm)
     */
    val checkOutTime: String? = null

    /**
     * 出行提示自定义内容
     */
    val extra: String? = null

}

/**
 * 费用政策
 */
class ExpensePolicy {

    /**
     * 加早政策
     */
    var breakfast: Breakfast? = null

    /**
     * 费用政策自定义内容
     */
    var extra: String? = null

    /**
     * 加床政策
     */
    var extraBed: ExtraBedPolicy? = null

}

/**
 * 加床政策
 */
class ExtraBedPolicy(
    /**
     * 加床费用/每人，单位人民币分 不支持加床填0
     */
    var price: Long?,
    /**
     * 加床政策; 0 - 不支持加床; 1 - 支持加床
     */
    var type: Int?,
) {
    constructor() : this(null, null)
}

class Floor {

    /**
     * 楼层开始
     */
    var start: Int? = null

    /**
     * 楼层结束
     */
    var end: Int? = null

}

class AmendPolicy {

    /**
     * 退订，改签政策
     */
    var cancelAmend: CancelAmend? = null

    /**
     * 退改政策自定义内容
     */
    var extra: String? = null

}

/**
 * 退订，改签政策
 */
class CancelAmend {

    /**
     * 退改支持类型; 0 - 不支持退改;
     * 1 - 支持退改 (目前流程里均无退改，前端文案'预订后若需更改日期或退款，请致电xx')
     */
    var type: Int? = null

}

class PayItemGroup(
    /**
     * 标题
     */
    var groupName: String?,
    /**
     * 菜品
     */
    var itemList: List<Item>?,
) {
    constructor() : this(null, null)
}

class Item {

    /**
     * 数量
     */
    var count: Int? = null

    /**
     * 菜名
     */
    var name: String? = null


    /**
     * 单价，分
     */
    var price: Int? = null


}
