package com.ganinfo.test.controller;

import com.ganinfo.test.mapper.TestMapper;
import com.ganinfo.test.service.TestService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author laocunzhang
 * @package:com.ganinfo.test.controller
 * @className:Test
 * @description:
 * @date 2018-01-28 15:16
 **/
@RestController
public class TestController {
    @Autowired
    private TestService testService;

    @ApiOperation(value = "第一个接口", notes = "hello接口")
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "hello Spring boot";
    }


    @ApiOperation(value = "查询测试", notes = "查询测试")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<Map<String,Object>> reids() {
        Map map = new HashMap();
        return testService.getUserList();
    }

    @ApiOperation(value = "查询测试", notes = "查询测试")
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String  add() {
        testService.insertUser();
        return "1";
    }
}
