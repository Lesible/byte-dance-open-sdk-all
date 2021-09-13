package com.sumwhy.bytedance.open.test

import com.sumwhy.bytedance.open.client.OauthClient
import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.test.context.SpringBootTest
import javax.annotation.Resource

@SpringBootTest
class AuthTests {

    @Resource
    lateinit var oauthClient: OauthClient

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
    fun clientToken() {
        val clientToken = oauthClient.clientToken()
        log.info("clientToken:{}", clientToken)
    }

    @Test
    fun larkOauth() {
        val larkAppOauth = oauthClient.larkAppOauth("1771de8710d3ce02",
            "clt.0794fcb419f390bd5488ac6c0c64aba5vhknlOmJjbpslBkRTpl789oa02su",
            "a-65ea2322cf5b0cb3f1585a1715c8774b0f8e29fa")
        log.info("larkAppOauth:{}", larkAppOauth)
    }

    companion object {
        val log: Logger = LoggerFactory.getLogger(this::class.java)
    }
}
