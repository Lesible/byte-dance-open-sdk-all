package com.sumwhy.bytedance.open.model.universal.poi.supplier

/**
 * <p>  </p>
 * <p> create by lesible at 2021-08-21 19:31</p>
 * @author 何嘉豪
 */
class EntryMiniApp {
    /**
     * 用于联调，1-使用测试版的小程序，0或者不填-使用正式版小程序
     */
    var isTest: Int? = null

    /**
     * 服务参数json
     */
    var params: String? = null

    /**
     * 服务路径
     */
    var path: String? = null

    /**
     * 小程序 appId
     */
    var appId: String? = null

    constructor()

    private constructor(builder: Builder) {
        this.isTest = builder.isTest
        this.params = builder.params
        this.path = builder.path
        this.appId = builder.appId
    }

    companion object {

        @JvmStatic
        fun builder(path: String, appId: String) = Builder(path, appId)
    }

    class Builder internal constructor(
        val path: String,
        val appId: String,
    ) {

        var isTest: Int? = null

        var params: String? = null

        fun isTest(isTest: Int): Builder {
            this.isTest = isTest
            return this
        }

        fun params(params: String): Builder {
            this.params = params
            return this
        }

        fun build() = EntryMiniApp(this)

    }

}