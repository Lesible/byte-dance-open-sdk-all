package com.sumwhy.bytedance.open.test

import com.sumwhy.bytedance.open.client.PoiOrderClient
import com.sumwhy.bytedance.open.model.req.poi.order.OrderStatusSyncReq
import com.sumwhy.bytedance.open.model.universal.poi.order.enumeration.OrderStatusEnum
import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.test.context.SpringBootTest
import javax.annotation.Resource

@SpringBootTest
class OrderPoiTests {

    @Resource
    lateinit var poiOrderClient: PoiOrderClient

    companion object {
        val log: Logger = LoggerFactory.getLogger(this::class.java)
    }

    @Test
    fun syncPoiSupplier() {
        val orderStatusSyncReq = OrderStatusSyncReq("test", "test", OrderStatusEnum.ORDER_CONFIRMED, "test")
        val test = poiOrderClient.syncOrderStatus("test", orderStatusSyncReq)
        log.info("test: {}", test)
    }

}
