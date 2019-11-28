package com.ganinfo.test.service.impl;

import com.ganinfo.test.mapper.TestMapper;
import com.ganinfo.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
import java.util.Map;

/**
 * @author laocunzhang
 * @package:com.ganinfo.test.service.impl
 * @className:TestServiceImpl
 * @description:
 * @date 2018-01-28 20:04
 **/
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;
    @Override
    public List<Map<String, Object>> getUserList() {
        return testMapper.getUserList();
    }

    @Override
    @Transactional(value="transactionManager")
    public Integer insertUser() {
        try{
            testMapper.insertUser();
            int i=1/0;
            testMapper.insertUser();
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }

        return 1;
    }
}
