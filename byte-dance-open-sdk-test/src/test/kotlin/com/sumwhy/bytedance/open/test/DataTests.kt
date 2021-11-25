package com.sumwhy.bytedance.open.test

import com.sumwhy.bytedance.open.client.DataFansClient
import com.sumwhy.bytedance.open.client.DataUserClient
import com.sumwhy.bytedance.open.client.DataVideoClient
import com.sumwhy.bytedance.open.model.req.data.DataBaseParam
import com.sumwhy.bytedance.open.model.req.data.external.UserDataParam
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

    @Resource
    lateinit var dataUserClient: DataUserClient

    @Resource
    lateinit var dataFansClient: DataFansClient

    @Test
    fun videoBaseInfo() {
        val itemBase = dataVideoClient.getItemBase(VideoDataParam(ITEM_ID, 7, OPEN_ID, ACCESS_TOKEN))
        log.info("itemBase: {}", itemBase)
    }

    @Test
    fun userFansInfo() {
        val itemBase = dataUserClient.getUserFans(UserDataParam(7, OPEN_ID, ACCESS_TOKEN))
        log.info("itemBase: {}", itemBase)
    }

    @Test
    fun userFansData() {
        val fansData = dataFansClient.getFansData(DataBaseParam(OPEN_ID, ACCESS_TOKEN))
        log.info("fansData: {}", fansData)
    }

    @Test
    fun videoPlayInfo() {
        val itemPlay = dataVideoClient.getItemPlay(VideoDataParam(ITEM_ID, 7, OPEN_ID, ACCESS_TOKEN))
        log.info("itemBase: {}", itemPlay)
    }

    companion object {
        val log: Logger = LoggerFactory.getLogger(this::class.java)
        const val ACCESS_TOKEN = "act.96a28e50d2651433d097ed54e490890ec2yh5MMhHgiM7tTRB6PXvyKUEIde"
        const val OPEN_ID = "0b5ddea1-b6d0-49b0-a273-27b56c66b3b6"
        const val ITEM_ID = "@9Vxc0aqXSsM5b2D0dt41Qc783WfgO/+EM5J0qA+iL1AUa/T960zdRmYqig357zEBAB/FASalehnNv8/PvrcCtQ=="
    }
}
