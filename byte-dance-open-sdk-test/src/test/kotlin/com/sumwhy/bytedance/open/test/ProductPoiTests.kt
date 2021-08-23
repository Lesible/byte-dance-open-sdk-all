package com.sumwhy.bytedance.open.test

import com.sumwhy.bytedance.open.client.PoiProductClient
import com.sumwhy.bytedance.open.model.req.poi.product.SkuAttributes
import com.sumwhy.bytedance.open.model.req.poi.product.SkuSyncReq
import com.sumwhy.bytedance.open.model.req.poi.product.SyncingSku
import com.sumwhy.bytedance.open.model.universal.poi.enumeration.OnlineStatusEnum
import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.test.context.SpringBootTest
import javax.annotation.Resource

@SpringBootTest
class ProductPoiTests {

    @Resource
    lateinit var poiProductClient: PoiProductClient

    companion object {
        val log: Logger = LoggerFactory.getLogger(this::class.java)
    }

    @Test
    fun syncPoiSupplier() {
        val skuSyncReq = SkuSyncReq(
            listOf(
                SyncingSku.builder()
                    .attributes(SkuAttributes("test")).stock(1234L)
                    .price(1234L).status(OnlineStatusEnum.ONLINE_STATUS)
                    .build()
            ),
            "test")
        val syncSkuResult = poiProductClient.syncSku("test_access_token", skuSyncReq)
        log.info("skuSyncReq: {}", syncSkuResult)
    }
}
