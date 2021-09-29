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
        val userInfo =userClient.userInfo("act.6d0532520b3e386f2a0356b458037beacbJVdTFJZxZb94qX0cu35d83MCnx",
        "334f2263-a9d8-4c07-bee4-f727a9d7a62f")
        log.info("refreshToken:{}", userInfo)
    }


    companion object {
        val log: Logger = LoggerFactory.getLogger(this::class.java)
    }
}
