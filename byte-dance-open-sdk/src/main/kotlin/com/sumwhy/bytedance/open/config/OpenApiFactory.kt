package com.sumwhy.bytedance.open.config

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.*
import com.sumwhy.bytedance.open.common.OpenCredentials
import com.sumwhy.bytedance.open.common.metadata.ByteDanceOpenSdkClientProperties
import okhttp3.ConnectionPool
import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

/**
 * <p> @date: 2021-07-28 11:41</p>
 * @author 何嘉豪
 */
@Configuration
class OpenApiFactory(private val clientProp: ByteDanceOpenSdkClientProperties) {

    @Bean
    fun openCredentials() = OpenCredentials(clientProp.key, clientProp.secret)

    private val retrofit: Retrofit by lazy {
        val okHttpProp = clientProp.okHttp
        // 初始化连接池配置
        val poolConfig = okHttpProp.connectionPoolConfiguration
        val pool = ConnectionPool(poolConfig.connectionMaxIdle,
            poolConfig.keepAliveDuration.seconds, TimeUnit.SECONDS)
        // 构建 okHttp 属性
        val connectionSpecs = listOf(
            ConnectionSpec.MODERN_TLS,
            ConnectionSpec.COMPATIBLE_TLS)
        val okHttpBuilder = OkHttpClient.Builder().connectionSpecs(connectionSpecs)
            .connectTimeout(okHttpProp.connectTimeout)
            .readTimeout(okHttpProp.readTimeout).writeTimeout(okHttpProp.writeTimeout)
            .callTimeout(okHttpProp.callTimeout).connectionPool(pool)
            .retryOnConnectionFailure(okHttpProp.retryOnConnectionFailure)
        // 排查问题可以打开日志
        if (clientProp.enableHttpLogging) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            okHttpBuilder.addInterceptor(loggingInterceptor)
        }
        val okHttpClient = okHttpBuilder.build()
        // 构建 retrofit 对象
        Retrofit.Builder().baseUrl(OPEN_URL).client(okHttpClient)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(JacksonConverterFactory.create(fastJsonLikeObjectMapper()))
            .build()
    }

    /**
     * fastJson 相似的 om, 适配抖音返回数据
     */
    fun fastJsonLikeObjectMapper(): ObjectMapper {
        val objectMapper = ObjectMapper()
        objectMapper.findAndRegisterModules()
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true)
        objectMapper.configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true)
        objectMapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true)
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
        objectMapper.propertyNamingStrategy = PropertyNamingStrategy.SNAKE_CASE
        return objectMapper
    }

    fun <T> generateApi(api: Class<T>) = retrofit.create(api)

    companion object {
        const val OPEN_URL = "https://open.douyin.com"
    }
}