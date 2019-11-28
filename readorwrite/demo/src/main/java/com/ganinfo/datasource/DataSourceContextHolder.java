package com.ganinfo.datasource;

import com.ganinfo.common.enums.DataSourceType;
import org.apache.log4j.Logger;

/**
 * @package:com.ganinfo.datasource
 * @className:DataSourceContextHolder
 * @description:本地线程全局变量
 * @author laocunzhang
 * @date 2018-01-28 14:41
 **/

public class DataSourceContextHolder {
    private static  Logger logger = Logger.getLogger(DataSourceContextHolder.class);
    private static final ThreadLocal<String> local = new ThreadLocal<String>();

    public static ThreadLocal<String> getLocal() {
        return local;
    }

    /**
     * 读可能是多个库
     */
    public static void read() {
        logger.debug("读操作-----");
        local.set(DataSourceType.read.getType());
    }

    /**
     * 写只有一个库
     */
    public static void write() {
        logger.debug("写操作-----");
        local.set(DataSourceType.write.getType());
    }

    public static void clearDB(){
        local.remove();
    }
    public static String getJdbcType() {
        return local.get();
    }
}
