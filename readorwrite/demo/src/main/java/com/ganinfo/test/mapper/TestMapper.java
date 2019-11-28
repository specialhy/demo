package com.ganinfo.test.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author laocunzhang
 * @package:com.ganinfo.test.mapper
 * @className:TestMapper
 * @description:
 * @date 2018-01-28 15:14
 **/
@Mapper
public interface TestMapper {

    List<Map<String,Object>> getUserList();

    Integer insertUser();

}
