package com.sumwhy.bytedance.open.test

import com.sumwhy.bytedance.open.client.EnterpriseClient
import com.sumwhy.bytedance.open.model.req.enterprise.BizToolBindItemReq
import com.sumwhy.bytedance.open.model.req.enterprise.BizToolListReq
import com.sumwhy.bytedance.open.model.universal.enterprise.enumeration.BindTypeEnum
import com.sumwhy.bytedance.open.model.universal.enterprise.enumeration.BizToolTypeEnum
import org.junit.jupiter.api.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.test.context.SpringBootTest
import javax.annotation.Resource

@SpringBootTest
class EnterpriseTests {

    @Resource
    lateinit var enterpriseClient: EnterpriseClient

    @Test
    fun listBizTool() {
        val bizToolListReq = BizToolListReq(ACCESS_TOKEN, OPEN_ID, 0, 10, BizToolTypeEnum.ONLINE_RESERVE)
        val bizToolListResult = enterpriseClient.listBizTool(bizToolListReq)
        log.info("bizToolListResult: {}", bizToolListResult)
    }

    /**
     * @9Vxc0aqXSsM5b2D0dt41Qc783WfgO/+EM5J0qA+iL1AUa/T960zdRmYqig357zEBAB/FASalehnNv8/PvrcCtQ==
     * @9Vxc0aqXSsM5b2D0dt41Qc783WPsNfuKM5N1qAOkLFYVbvf460zdRmYqig357zEBOi0RCAGd99q2ZKu8bpq7+w==
     */
    @Test
    fun bindBizTool2Item() {
        val req =
            BizToolBindItemReq.builder("@9Vxc0aqXSsM5b2D0dt41Qc783WfgO/+EM5J0qA+iL1AUa/T960zdRmYqig357zEBAB/FASalehnNv8/PvrcCtQ==",
                BizToolTypeEnum.ONLINE_RESERVE, BindTypeEnum.BOUND)
                .toolId("@9Vxc0aqXSsM5b2D0dt41Qc791WXrPPqLOJxwqAujLFYQbfX060zdRmYqig357zEBT+yHl/Fvp1slrmIabeybOg==")
                .build()
        val bindBizTool2Item = enterpriseClient.bindBizTool2Item(ACCESS_TOKEN, OPEN_ID, req)
        log.info("bindBizTool2Item: {}", bindBizTool2Item)
    }

    @Test
    fun listItemBindBizTool() {
        val itemBindBizToolList = enterpriseClient.listItemBindBizTool(ACCESS_TOKEN, OPEN_ID, listOf(
            "@9Vxc0aqXSsM5b2D0dt41Qc783WfgO/+EM5J0qA+iL1AUa/T960zdRmYqig357zEBAB/FASalehnNv8/PvrcCtQ==",
            "@9Vxc0aqXSsM5b2D0dt41Qc783WPsNfuKM5N1qAOkLFYVbvf460zdRmYqig357zEBOi0RCAGd99q2ZKu8bpq7+w=="
        ))
        log.info("itemBindBizToolList: {}", itemBindBizToolList)
    }

    companion object {
        val log: Logger = LoggerFactory.getLogger(this::class.java)
        const val ACCESS_TOKEN = "act.9ccd30d4b98e1d0938c2b9156bb0b74efHuhXSDN6LYgqsJYbRZdHViCpbRA"
        const val OPEN_ID = "0b5ddea1-b6d0-49b0-a273-27b56c66b3b6"
    }
}
