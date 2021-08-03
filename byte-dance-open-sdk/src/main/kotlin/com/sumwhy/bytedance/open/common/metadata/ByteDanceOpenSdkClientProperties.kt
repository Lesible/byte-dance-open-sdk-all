package com.sumwhy.bytedance.open.common.metadata

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.boot.context.properties.NestedConfigurationProperty

/**
 * <p> @date: 2021-07-27 20:53</p>
 * @author 何嘉豪
 */
@ConstructorBinding
@ConfigurationProperties(prefix = "byte-dance.open")
data class ByteDanceOpenSdkClientProperties(
    val key: String,
    val secret: String,
    val enableHttpLogging: Boolean = false,
    @NestedConfigurationProperty val okHttp: OkHttpProperties = OkHttpProperties(),
)