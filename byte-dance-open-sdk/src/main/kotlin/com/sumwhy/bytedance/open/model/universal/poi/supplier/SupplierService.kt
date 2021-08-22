package com.sumwhy.bytedance.open.model.universal.poi.supplier

import com.sumwhy.bytedance.open.model.universal.poi.supplier.enumeration.OnlineStatusEnum
import com.sumwhy.bytedance.open.model.universal.poi.supplier.enumeration.ServiceTypeEnum

/**
 * <p> @date: 2021-08-21 18:02</p>
 * @author Lesible
 */
class SupplierService {

    /**
     * 上线状态(1:上线，2:下线)
     */
    var enable: OnlineStatusEnum? = null

    /**
     * 服务入口拼接参数
     */
    var entry: SupplierEntry? = null

    /**
     * 服务类型
     */
    var serviceType: ServiceTypeEnum? = null

    constructor()

    private constructor(builder: Builder) {
        this.enable = builder.enable
        this.entry = builder.entry
        this.serviceType = builder.serviceType
    }

    companion object {
        @JvmStatic
        fun builder(enable: OnlineStatusEnum, entry: SupplierEntry, serviceType: ServiceTypeEnum) =
            Builder(enable, entry, serviceType)
    }

    class Builder internal constructor(
        val enable: OnlineStatusEnum,
        val entry: SupplierEntry,
        val serviceType: ServiceTypeEnum
    ) {

        fun build() = SupplierService(this)

    }

}
