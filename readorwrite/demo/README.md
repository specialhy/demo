# Springboot多数据源开发框架

**包命名规则**<br /> 
新建业务包需要符合com.gainfo.模块名称.业务层的标准 <br /> 
例如：com.ganinfo.car.controller,com.ganinfo.car.service

**DAO中的方法名标准**
查询方法名要以：select、get、query开头
新增、更新分别以：insert、update开头

**从库数据源个数** <br /> 
spring.datasource.readSize=2 <br /> 
如果修改从数据源格式，需要对应修改config中的DataBaseConfiguration.class,修改相应的从数据源配置 <br /> 

**Mybatis配置** <br /> 
spring.mybatis.configLocation=mybatis/mybatis.xml <br /> 

**mapper路径**<br /> 
spring.mybatis.mapperLocations=mapper/*.xml <br /> 

**数据源监控地址**：ip:port/*/druid/login.html <br /> 
username:admin <br /> 
password:123456 <br /> 

**API查看地址**：ip:port/*/swagger-ui.html



