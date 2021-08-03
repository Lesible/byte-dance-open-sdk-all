package com.sumwhy.bytedance.open.common.metadata

import java.time.Duration

/**
 * <p> @date: 2021-07-27 16:29</p>
 * @author 何嘉豪
 */
class OkHttpProperties {
    var connectTimeout: Duration = Duration.ofSeconds(10L)
    var writeTimeout: Duration = Duration.ofSeconds(10L)
    var readTimeout: Duration = Duration.ofSeconds(10L)
    var callTimeout: Duration = Duration.ZERO
    var retryOnConnectionFailure: Boolean = false
    val connectionPoolConfiguration: ConnectionPoolConfiguration = ConnectionPoolConfiguration()

    class ConnectionPoolConfiguration {
        var connectionMaxIdle: Int = 20
        var keepAliveDuration: Duration = Duration.ofMinutes(1L)
    }
}
