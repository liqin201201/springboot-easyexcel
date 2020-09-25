package com.example.springboot03.log.model;

import java.io.Serializable;
import lombok.Data;
import java.util.Date;

/**
 *  接口访问记录
 * @author liqin 2020-09-25
 */
@Data
public class LogInterfaceRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 日志id
     */
    private String logId;

    /**
     * 接口url
     */
    private String url;

    /**
     * 参数：u.url的参数;b.body的参数
     */
    private String params;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 方法全限定名
     */
    private String methodName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    public LogInterfaceRecord() {
    }

}
