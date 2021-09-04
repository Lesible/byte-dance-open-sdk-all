package com.sumwhy.bytedance.open.test

import com.sumwhy.bytedance.open.client.DataVideoClient
import com.sumwhy.bytedance.open.model.req.data.external.VideoDataParam
import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.test.context.SpringBootTest
import javax.annotation.Resource

@SpringBootTest
class DataTests {

    @Resource
    lateinit var dataVideoClient: DataVideoClient

    @Test
    fun videoBaseInfo() {
        val itemBase = dataVideoClient.getItemBase(VideoDataParam(ITEM_ID, 7, OPEN_ID, ACCESS_TOKEN))
        log.info("itemBase: {}", itemBase)
    }

    companion object {
        val log: Logger = LoggerFactory.getLogger(this::class.java)
        const val ACCESS_TOKEN = "act.9ccd30d4b98e1d0938c2b9156bb0b74efHuhXSDN6LYgqsJYbRZdHViCpbRA"
        const val OPEN_ID = "0b5ddea1-b6d0-49b0-a273-27b56c66b3b6"
        const val ITEM_ID = "@9Vxc0aqXSsM5b2D0dt41Qc783WfgO/+EM5J0qA+iL1AUa/T960zdRmYqig357zEBAB/FASalehnNv8/PvrcCtQ=="
    }
}
