package com.sumwhy.bytedance.open.autoconfigure

import com.sumwhy.bytedance.open.api.DataApi
import com.sumwhy.bytedance.open.api.OauthApi
import com.sumwhy.bytedance.open.api.UserApi
import com.sumwhy.bytedance.open.api.VideoApi
import com.sumwhy.bytedance.open.client.*
import com.sumwhy.bytedance.open.common.OpenCredentials
import com.sumwhy.bytedance.open.common.metadata.ByteDanceOpenSdkClientProperties
import com.sumwhy.bytedance.open.config.OpenApiFactory
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

/**
 * <p> @date: 2021-07-27 20:50</p>
 *
 * @author 何嘉豪
 */
@Configuration
@Import(OpenApiFactory::class)
@ComponentScan("com.sumwhy.bytedance.open")
@EnableConfigurationProperties(ByteDanceOpenSdkClientProperties::class)
class ByteDanceOpenSdkAutoConfiguration {

    @Bean
    fun oauthClient(openApiFactory: OpenApiFactory, openCredentials: OpenCredentials) =
        OauthClient(openApiFactory.generateApi(OauthApi::class.java), openCredentials)

    @Bean
    fun videoClient(openApiFactory: OpenApiFactory) =
        VideoClient(openApiFactory.generateApi(VideoApi::class.java))

    @Bean
    fun userClient(openApiFactory: OpenApiFactory) =
        UserClient(openApiFactory.generateApi(UserApi::class.java))

    @Bean
    fun userDataClient(openApiFactory: OpenApiFactory) =
        DataUserClient(openApiFactory.generateApi(DataApi::class.java))

    @Bean
    fun videoDataClient(openApiFactory: OpenApiFactory) =
        DataVideoClient(openApiFactory.generateApi(DataApi::class.java))

}
