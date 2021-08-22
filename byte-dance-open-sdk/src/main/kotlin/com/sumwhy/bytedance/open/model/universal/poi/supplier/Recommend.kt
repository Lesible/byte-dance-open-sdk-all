package com.sumwhy.bytedance.open.model.universal.poi.supplier


/**
 * 推荐
 *
 * @author 何嘉豪
 */
class Recommend {
    /**
     * 推荐内容链接(图片，或者视频链接）
     */
    var imageUrl: String? = null

    /**
     * 推荐描述
     */
    var title: String? = null

    constructor()

    private constructor(builder: Builder) {
        this.imageUrl = builder.imageUrl
        this.title = builder.title
    }

    companion object {

        @JvmStatic
        fun builder(imageUrl: String, title: String) = Builder(imageUrl, title)

    }

    class Builder(
        var imageUrl: String,
        var title: String
    ) {
        fun build() = Recommend(this)
    }
}
