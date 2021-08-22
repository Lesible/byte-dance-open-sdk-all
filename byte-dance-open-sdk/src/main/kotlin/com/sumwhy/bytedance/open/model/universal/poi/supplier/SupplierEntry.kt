package com.sumwhy.bytedance.open.model.universal.poi.supplier

import com.sumwhy.bytedance.open.model.universal.poi.supplier.enumeration.EntryTypeEnum

/**
 * <p>  </p>
 * <p> create by lesible at 2021-08-21 19:30</p>
 * @author 何嘉豪
 */
class SupplierEntry {

    /**
     * 抖音小程序入口参数
     */
    var entryMiniApp: EntryMiniApp? = null

    /**
     * 入口类型(1:H5，2:抖音小程序)
     */
    var entryType: EntryTypeEnum? = null

    constructor()

    private constructor(builder: Builder) {
        this.entryMiniApp = builder.entryMiniApp
        this.entryType = builder.entryType
    }

    companion object {
        fun builder(entryMiniApp: EntryMiniApp, entryType: EntryTypeEnum) =
            Builder(entryMiniApp, entryType)
    }

    class Builder internal constructor(
        val entryMiniApp: EntryMiniApp,
        val entryType: EntryTypeEnum
    ) {
        fun build() = SupplierEntry(this)
    }

}