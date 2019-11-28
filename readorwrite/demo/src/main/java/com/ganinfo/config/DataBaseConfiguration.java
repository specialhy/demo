package com.ganinfo.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * @package:com.ganinfo.config
 * @className:DataBaseConfiguration
 * @description:读取mybatis.properties配置文件
 * @author laocunzhang
 * @date 2018-01-28 13:48
 **/

@Configuration
//@PropertySource("classpath:mybatis/mybatis.properties")
public class DataBaseConfiguration {
    private Logger logger = Logger.getLogger(DataBaseConfiguration.class);
    @Value("${spring.datasource.type}")
    private Class<? extends DataSource> dataSourceType;

    @Bean(name="writeDataSource", destroyMethod = "close", initMethod="init")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource writeDataSource() {
        logger.info("-------------------- writeDataSource init ---------------------");
        DataSource dataSource=DataSourceBuilder.create().type(dataSourceType).build();
        return dataSource;
    }
    /**
     * 有多少个从库就要配置多少个
     * @return
     */
    @Bean(name = "readDataSource1")
    @ConfigurationProperties(prefix = "spring.slave")
    public DataSource readDataSourceOne(){
        logger.info("-------------------- readDataSourceOne init --------------------");
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    @Bean(name = "readDataSource2")
    @ConfigurationProperties(prefix = "spring.read2")
    public DataSource readDataSourceTwo() {
        logger.info("-------------------- readDataSourceTwo init --------------------");
        return DataSourceBuilder.create().type(dataSourceType).build();
    }
    
    @Bean("readDataSources")
    public List<DataSource> readDataSources(){
        List<DataSource> dataSources=new ArrayList<>();
        dataSources.add(readDataSourceOne());
        dataSources.add(readDataSourceTwo());
        return dataSources;
    }
}
