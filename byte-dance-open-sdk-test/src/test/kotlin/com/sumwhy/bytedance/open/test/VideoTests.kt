package com.sumwhy.bytedance.open.test

import com.sumwhy.bytedance.open.client.DataUserClient
import com.sumwhy.bytedance.open.client.DataVideoClient
import com.sumwhy.bytedance.open.client.UserClient
import com.sumwhy.bytedance.open.client.VideoClient
import com.sumwhy.bytedance.open.model.req.UniversalListParam
import com.sumwhy.bytedance.open.model.req.data.external.UserDataParam
import com.sumwhy.bytedance.open.model.req.data.external.VideoDataParam
import com.sumwhy.bytedance.open.util.ResultWalkUtil
import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.test.context.SpringBootTest
import javax.annotation.Resource

@SpringBootTest
class VideoTests {

    @Resource
    lateinit var videoClient: VideoClient

    @Resource
    lateinit var dataUserClient: DataUserClient

    @Resource
    lateinit var dataVideoClient: DataVideoClient

    @Resource
    lateinit var walkUtil: ResultWalkUtil

    @Resource
    lateinit var userClient: UserClient

    @Test
    fun listVideo() {
        val universalListParam = UniversalListParam.builder(
            "b69bf022-7229-4a1f-9ca2-32ab13720fe5",
            "act.f6efc8c85dd5b2deabd826e6a5703d6frPgdFNHAQvoiYHfwS2ULzuAjZgdv", 10
        ).build()
        val listVideo = videoClient.listVideo(universalListParam)
        log.info("listVideo:{}", listVideo)
    }

    @Test
    fun listFans() {
        val universalListParam = UniversalListParam.builder(
            "b69bf022-7229-4a1f-9ca2-32ab13720fe5",
            "act.f6efc8c85dd5b2deabd826e6a5703d6frPgdFNHAQvoiYHfwS2ULzuAjZgdv", 10
        ).build()
        val listFans = userClient.listFans(universalListParam)
        log.info("listFans:{}", listFans)
    }

    @Test
    fun walkVideo() {
        val initParam = UniversalListParam.builder(
            "160d7dfc-edc4-4a28-a755-0e4522a75788",
            "act.44d028f8eb813b1d11aef758eb931bb7NFB8iwzCH2irpbr89TCttjJuDHhZ", 10
        ).build()
        walkUtil.walkVideoList(initParam, { log.info("{}", it) })
    }

    @Test
    fun dataUser() {
        val dataBaseParam = UserDataParam(
            5,
            "160d7dfc-edc4-4a28-a755-0e4522a75788", "act.44d028f8eb813b1d11aef758eb931bb7NFB8iwzCH2irpbr89TCttjJuDHhZ"
        )
        println(dataUserClient.getUserComment(dataBaseParam))
        println(dataUserClient.getUserFans(dataBaseParam))
        println(dataUserClient.getUserItem(dataBaseParam))
        println(dataUserClient.getUserLike(dataBaseParam))
        println(dataUserClient.getUserProfile(dataBaseParam))
        println(dataUserClient.getUserShare(dataBaseParam))
    }

    @Test
    fun dataVideo() {
        val videoDataParam =
            VideoDataParam(
                "@9Vxc0aqXSsM5b2D0dt41Qc783GztNPCFMpxyrQmuLlAQbvf960zdRmYqig357zEBNxaM7PuU+F5bEIfWd7Kb9Q==",
                openId = "a7701ce7-fc87-4859-8af0-2f691107bfb2",
                accessToken = "act.aecdaa4d437806d57ea1b1eda16f0a10WaFe48viEi71n7QBuvRByTdNL0eE"
            )
        val itemBase = dataVideoClient.getItemBase(videoDataParam)
        log.info("itemBase:{}", itemBase)
        val videoDataParamDate =
            VideoDataParam(
                "@9Vxc0aqXSsM5b2D0dt41Qc783GztNPCFMpxyrQmuLlAQbvf960zdRmYqig357zEBNxaM7PuU+F5bEIfWd7Kb9Q==",
                15, "a7701ce7-fc87-4859-8af0-2f691107bfb2",
                "act.aecdaa4d437806d57ea1b1eda16f0a10WaFe48viEi71n7QBuvRByTdNL0eE"
            )
        val itemPlay = dataVideoClient.getItemPlay(videoDataParamDate)
        log.info("itemPlay:{}", itemPlay)
    }

    companion object {
        val log: Logger = LoggerFactory.getLogger(this::class.java)
    }

}
