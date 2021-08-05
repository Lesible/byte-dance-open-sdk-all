package com.sumwhy.bytedance.open.test

import com.sumwhy.bytedance.open.client.OauthClient
import com.sumwhy.bytedance.open.client.VideoClient
import com.sumwhy.bytedance.open.model.req.video.ListVideoParam
import com.sumwhy.bytedance.open.util.ResultWalkUtil
import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.test.context.SpringBootTest
import javax.annotation.Resource

@SpringBootTest
class ByteDanceOpenSdkTestApplicationTests {

    @Resource
    lateinit var oauthClient: OauthClient

    @Resource
    lateinit var videoClient: VideoClient

    @Resource
    lateinit var walkUtil: ResultWalkUtil

    @Test
    fun refreshToken() {
        val refreshToken =
            oauthClient.refreshToken(refreshToken = "rft.575c7fb63f2cbf3c5e45848079052176vffXa2V1Sunnyz34W3MvbI1bfIFl")
        log.info("refreshToken:{}", refreshToken)
    }

    @Test
    fun renewRefreshToken() {
        val refreshToken =
            oauthClient.renewRefreshToken(refreshToken = "rft.575c7fb63f2cbf3c5e45848079052176vffXa2V1Sunnyz34W3MvbI1bfIFl")
        log.info("refreshToken:{}", refreshToken)
    }

    @Test
    fun listVideo() {
        val listVideoParam = ListVideoParam.builder("b69bf022-7229-4a1f-9ca2-32ab13720fe5",
            "act.f6efc8c85dd5b2deabd826e6a5703d6frPgdFNHAQvoiYHfwS2ULzuAjZgdv", 10).build()
        val listVideo = videoClient.listVideo(listVideoParam)
        log.info("listVideo:{}", listVideo)
    }

    @Test
    fun walkVideo() {
        val initParam = ListVideoParam.builder("160d7dfc-edc4-4a28-a755-0e4522a75788",
            "act.44d028f8eb813b1d11aef758eb931bb7NFB8iwzCH2irpbr89TCttjJuDHhZ", 10).build()
        walkUtil.walkVideoList(initParam, { log.info("{}", it) })
    }

    companion object {
        val log: Logger = LoggerFactory.getLogger(this::class.java)
    }


}
