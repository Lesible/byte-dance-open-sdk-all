package com.sumwhy.bytedance.open.test

import com.sumwhy.bytedance.open.client.UserClient
import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.test.context.SpringBootTest
import javax.annotation.Resource

@SpringBootTest
class UserInfoTests {

    @Resource
    lateinit var userClient: UserClient

    @Test
    fun userInfo() {
        val userInfo = userClient.userInfo(ACCESS_TOKEN, OPEN_ID)
        log.info("userInfo:{}", userInfo)
    }


    companion object {
        val log: Logger = LoggerFactory.getLogger(this::class.java)
        const val ACCESS_TOKEN = "act.ebc8d4edc5ac4816302831f63102a412fbhiZVsi7GH4M2kvBsJpixf90dhj"
        const val OPEN_ID = "6db59c6a-2f1c-4f1a-88b3-dfab71fe420a"
    }
}
