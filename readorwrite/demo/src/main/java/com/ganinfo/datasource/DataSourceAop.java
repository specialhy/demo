package com.ganinfo.datasource;


import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
/**
 * @author laocunzhang
 * @package:com.ganinfo.datasource
 * @className:DataSourceAop
 * @description:拦截设置本地线程变量 ,切换数据源
 * @date 2018-01-28 15:05
 **/
@Aspect
@Order(-1)// 保证该AOP在@Transactional之前执行
@Component
public class DataSourceAop {
    private static Logger logger = Logger.getLogger(DataSourceAop.class);
    @Before("execution(* com.ganinfo.*.mapper..*.select*(..)) || execution(* com.ganinfo.*.mapper..*.get*(..))|| execution(* com.ganinfo.*.mapper..*.query*(..))")
    public void setReadDataSourceType() {
        DataSourceContextHolder.read();
        logger.info("dataSource 切换到：Read");
    }

    @Before("execution(* com.ganinfo.*.mapper..*.insert*(..)) || execution(* com.ganinfo.*.mapper..*.update*(..))")
    public void setWriteDataSourceType() {
        DataSourceContextHolder.write();
        logger.info("dataSource 切换到：Write");
    }
    @After("execution(* com.ganinfo.*.mapper..*.*(..))")
    public void remove(){
        DataSourceContextHolder.clearDB();
        logger.info("dataSource clear");
    }
}
