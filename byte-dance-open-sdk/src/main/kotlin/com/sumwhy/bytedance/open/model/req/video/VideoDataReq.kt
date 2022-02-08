package com.sumwhy.bytedance.open.model.req.video

/**
 * <p>  </p>
 * <p> created at 2021-12-29 16:25 by lesible </p>
 * @author 何嘉豪
 */
class VideoDataReq private constructor(builder: Builder) {

    val itemIds: List<String> = builder.itemIds

    companion object {

        @JvmStatic
        fun builder(itemIds: List<String>) = Builder(itemIds)

    }

    class Builder(val itemIds: List<String>) {
        fun build() = VideoDataReq(this)
    }

}