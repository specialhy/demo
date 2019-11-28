package com.ganinfo.test.service;

import java.util.List;
import java.util.Map;

/**
 * @author laocunzhang
 * @package:com.ganinfo.test.service
 * @className:TestService
 * @description:
 * @date 2018-01-28 20:03
 **/
public interface TestService {

    List<Map<String,Object>> getUserList();

    Integer insertUser();
}
