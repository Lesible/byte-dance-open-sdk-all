package com.sumwhy.bytedance.open.model.resp.data

import com.sumwhy.bytedance.open.model.resp.BaseData

/**
 * <p> 用户数据返回实体 </p>
 * <p> create 2021-08-06 10:41 by lesible </p>
 * @author 何嘉豪
 */
data class BaseDataResult<T>(
    /**
     * 结果集
     */
    val resultList: List<T>?,

    /**
     * 错误码描述
     */
    override val description: String,

    /**
     * 错误码
     */
    override val errorCode: Int,
) : BaseData(errorCode, description)
