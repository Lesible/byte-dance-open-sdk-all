package com.sumwhy.bytedance.open.model.req.oauth

/**
 * <p>  </p>
 * <p> create 2021-09-09 14:36 by lesible </p>
 * @author 何嘉豪
 */
class LarkOauthReq private constructor(builder: Builder) {

    val larkCode = builder.larkCode
    val accessToken = builder.accessToken
    val larkAccessType = builder.larkAccessType
    val larkAccessToken = builder.larkAccessToken

    fun toParamMap() = mapOf(
        "lark_code" to larkCode,
        "access_token" to accessToken,
        "lark_access_type" to "app",
        "lark_access_token" to larkAccessToken
    )

    companion object {

        @JvmStatic
        fun builder(
            larkCode: String,
            accessToken: String,
            larkAccessType: String,
            larkAccessToken: String,
        ) = Builder(larkCode, accessToken, larkAccessType, larkAccessToken)
    }

    class Builder(
        val larkCode: String,
        val accessToken: String,
        val larkAccessType: String,
        val larkAccessToken: String,
    ) {
        fun build() = LarkOauthReq(this)
    }

}