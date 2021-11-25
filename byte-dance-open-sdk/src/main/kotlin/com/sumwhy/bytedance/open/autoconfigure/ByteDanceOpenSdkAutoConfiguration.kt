package com.sumwhy.bytedance.open.autoconfigure

import com.sumwhy.bytedance.open.api.*
import com.sumwhy.bytedance.open.client.*
import com.sumwhy.bytedance.open.common.OpenCredentials
import com.sumwhy.bytedance.open.common.metadata.ByteDanceOpenSdkClientProperties
import com.sumwhy.bytedance.open.config.OpenApiFactory
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
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
    @ConditionalOnMissingBean
    fun oauthApi(openApiFactory: OpenApiFactory) = openApiFactory.generateApi(OauthApi::class.java)

    @Bean
    fun oauthClient(oauthApi: OauthApi, openCredentials: OpenCredentials) =
        OauthClient(oauthApi, openCredentials)

    @Bean
    @ConditionalOnMissingBean
    fun videoApi(openApiFactory: OpenApiFactory) = openApiFactory.generateApi(VideoApi::class.java)

    @Bean
    fun videoClient(videoApi: VideoApi) = VideoClient(videoApi)

    @Bean
    @ConditionalOnMissingBean
    fun userApi(openApiFactory: OpenApiFactory) = openApiFactory.generateApi(UserApi::class.java)

    @Bean
    fun userClient(userApi: UserApi) = UserClient(userApi)

    @Bean
    @ConditionalOnMissingBean
    fun dataApi(openApiFactory: OpenApiFactory) = openApiFactory.generateApi(DataApi::class.java)

    @Bean
    fun userDataClient(dataApi: DataApi) = DataUserClient(dataApi)

    @Bean
    fun videoDataClient(dataApi: DataApi) = DataVideoClient(dataApi)

    @Bean
    @ConditionalOnMissingBean
    fun lifeOpenApi(openApiFactory: OpenApiFactory) = openApiFactory.generateApi(LifeOpenApi::class.java)

    @Bean
    fun poiSupplierClient(lifeOpenApi: LifeOpenApi) = PoiSupplierClient(lifeOpenApi)

    @Bean
    fun poiProductClient(lifeOpenApi: LifeOpenApi) = PoiProductClient(lifeOpenApi)

    @Bean
    fun poiOrderClient(lifeOpenApi: LifeOpenApi) = PoiOrderClient(lifeOpenApi)

    @Bean
    @ConditionalOnMissingBean
    fun enterpriseApi(openApiFactory: OpenApiFactory) = openApiFactory.generateApi(EnterpriseApi::class.java)

    @Bean
    fun enterpriseClient(enterpriseApi: EnterpriseApi) = EnterpriseClient(enterpriseApi)

    @Bean
    fun fansDataClient(dataApi: DataApi) = DataFansClient(dataApi)

}
