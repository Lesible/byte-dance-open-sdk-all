package com.sumwhy.bytedance.open.test

import com.sumwhy.bytedance.open.client.PoiSupplierClient
import com.sumwhy.bytedance.open.model.req.poi.supplier.SupplierMatchData
import com.sumwhy.bytedance.open.model.req.poi.supplier.SupplierMatchReq
import com.sumwhy.bytedance.open.model.resp.ByteDanceResp
import com.sumwhy.bytedance.open.model.resp.poi.supplier.QuerySupplierResult
import com.sumwhy.bytedance.open.model.resp.poi.supplier.SyncSupplierResult
import com.sumwhy.bytedance.open.model.universal.poi.supplier.HotelServiceFacility
import com.sumwhy.bytedance.open.model.universal.poi.supplier.SupplierAttributes
import com.sumwhy.bytedance.open.model.universal.poi.supplier.SyncSupplier.Companion.builder
import com.sumwhy.bytedance.open.model.universal.poi.supplier.enumeration.OnlineStatusEnum
import com.sumwhy.bytedance.open.model.universal.poi.supplier.enumeration.SupplierTypeEnum
import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.test.context.SpringBootTest
import javax.annotation.Resource

@SpringBootTest
class SupplierPoiTests {

    @Resource
    lateinit var poiSupplierClient: PoiSupplierClient

    companion object {
        val log: Logger = LoggerFactory.getLogger(this::class.java)
    }

    @Test
    fun syncPoiSupplier() {
        val build = builder(
            "test", OnlineStatusEnum.ONLINE_STATUS,
            SupplierTypeEnum.CAR, SupplierAttributes.builder()
                .hotelFacility(
                    listOf(
                        HotelServiceFacility.builder(1).name("test1").build(),
                        HotelServiceFacility.builder(2).name("test2").build()
                    )
                )
                .build(),
            "test", "test"
        ).build()
        val test: ByteDanceResp<SyncSupplierResult>? = poiSupplierClient.syncSupplier("test", build)
        log.info("test: {}", test)
    }

    @Test
    fun queryPoiSupplier() {
        val test: ByteDanceResp<QuerySupplierResult>? = poiSupplierClient
            .querySupplier("act.2b354eefc57741186fad8a29cefdb806JLOO9E1MMxuO2S58lTvfM9rjECk1", "12435235")
        log.info("test: {}", test)
    }

    @Test
    fun querySupplierMatchResultByTaskIds() {
        val matchResult =
            poiSupplierClient.querySupplierMatchResultByTaskIds(
                "act.2b354eefc57741186fad8a29cefdb806JLOO9E1MMxuO2S58lTvfM9rjECk1",
                listOf("aaa", "bbb"))
        log.info("matchResult:{}", matchResult)
    }

    @Test
    fun querySupplierMatchResultBySupplierExtIds() {
        val matchResult =
            poiSupplierClient.querySupplierMatchResultBySupplierExtIds(
                "act.2b354eefc57741186fad8a29cefdb806JLOO9E1MMxuO2S58lTvfM9rjECk1",
                listOf("aaa", "bbb"))
        log.info("matchResult:{}", matchResult)
    }

    @Test
    fun syncSupplierMatch() {
        val syncResult =
            poiSupplierClient.syncSupplierMatch(
                "act.2b354eefc57741186fad8a29cefdb806JLOO9E1MMxuO2S58lTvfM9rjECk1",
                SupplierMatchReq(listOf(SupplierMatchData.builder().supplierExtId("www").build())))
        log.info("syncResult:{}", syncResult)
    }
}
