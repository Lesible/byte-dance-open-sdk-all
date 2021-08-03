package com.sumwhy.bytedance.open.model.req.video

/**
 * <p>  </p>
 * <p> create 2021-08-02 11:46 by lesible</p>
 * @author 何嘉豪
 */
class ListVideoParam private constructor(builder: Builder) {

    private val openId = builder.openId
    private val accessToken = builder.accessToken
    private val count = builder.count
    private val cursor = builder.cursor

    fun toParamMap() = mapOf(
        "open_id" to openId,
        "access_token" to accessToken,
        "cursor" to cursor.toString(),
        "count" to count.toString()
    )

    fun clone(cursor: Long) =
        builder(this.openId, this.accessToken, this.count).cursor(cursor).build()

    companion object {
        @JvmStatic
        fun builder(openId: String, accessToken: String, count: Int) = Builder(openId, accessToken, count)
    }

    class Builder(
        val openId: String,
        val accessToken: String,
        val count: Int,
    ) {
        var cursor = 0L
        fun cursor(cursor: Long): Builder {
            this.cursor = cursor
            return this
        }

        fun build() = ListVideoParam(this)
    }

}