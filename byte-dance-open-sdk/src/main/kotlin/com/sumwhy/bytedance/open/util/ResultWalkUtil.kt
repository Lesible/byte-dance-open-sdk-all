package com.sumwhy.bytedance.open.util

import com.sumwhy.bytedance.open.client.VideoClient
import com.sumwhy.bytedance.open.model.req.video.ListVideoParam
import com.sumwhy.bytedance.open.model.resp.ByteDanceResp
import com.sumwhy.bytedance.open.model.resp.video.ListVideoResult
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import javax.annotation.Resource

/**
 * <p> 递归遍历 </p>
 * <p> create 2021-08-03 10:06 by lesible </p>
 * @author 何嘉豪
 */
@Component
class ResultWalkUtil {

    @Resource
    private lateinit var videoClient: VideoClient

    /**
     * 递归通用
     *
     * @param resultProducer 结果生产者, 一般为接口调用方法
     * @param resultConsumer 结果消费者, 一般为业务逻辑
     * @param breakPredicate 根据结果来停止递归的断言
     * @param initParam 初始化传参
     * @param nextParamProducer 根据结果构造新的传参
     */
    private fun <P, R> walk(
        resultProducer: (P) -> R?, resultConsumer: (R?) -> Unit,
        breakPredicate: (R?) -> Boolean, initParam: P, nextParamProducer: (R?) -> P,
    ) {
        try {
            val result = resultProducer.invoke(initParam) ?: return
            resultConsumer.invoke(result)
            if (breakPredicate.invoke(result)) {
                return
            }
            val nextParam = nextParamProducer.invoke(result)
            walk(resultProducer, resultConsumer, breakPredicate, nextParam, nextParamProducer)
        } catch (e: Exception) {
            log.error("递归遍历结果时,出现错误", e)
        }
    }

    /**
     * 遍历视频信息
     * @param breakPredicate 根据结果来停止递归的断言
     * @param resultConsumer 结果消费者,业务
     * @param initParam 初始化参数
     */
    @JvmOverloads
    fun walkVideoList(
        initParam: ListVideoParam, resultConsumer: (ByteDanceResp<ListVideoResult>?) -> Unit,
        breakPredicate: (ByteDanceResp<ListVideoResult>?) -> Boolean =
            { it == null || !it.data.isSuccessful() || it.data.hasMore?.not() ?: true },
    ) {
        walk<ListVideoParam, ByteDanceResp<ListVideoResult>?>({ videoClient.listVideo(it) },
            resultConsumer, breakPredicate, initParam,
            { initParam.clone(it?.data?.cursor ?: throw RuntimeException("impossible")) })
    }


    companion object {
        private val log: Logger = LoggerFactory.getLogger(this::class.java)
    }

}