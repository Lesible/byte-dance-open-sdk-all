package com.sumwhy.bytedance.open.model.resp.poi

import com.fasterxml.jackson.annotation.JsonProperty

/**
 * <p>  </p>
 * <p> create 2021-09-29 14:26 by lesible </p>
 * @author 何嘉豪
 */
data class SimpleExtra(

    @JsonProperty("logid")
    val logId: String,

    val now: Long,
)