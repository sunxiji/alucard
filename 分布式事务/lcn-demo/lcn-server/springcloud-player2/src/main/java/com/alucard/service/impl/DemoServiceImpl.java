package com.alucard.service.impl;

import com.alucard.client.Demo2Client;
import com.alucard.repository.TestMapper;
import com.alucard.entity.Test;
import com.alucard.service.DemoService;
import com.codingapi.tx.annotation.TxTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lorne on 2017/6/26.
 */
@Service
public class DemoServiceImpl implements DemoService {


    @Autowired
    private Demo2Client demo2Client;


    @Autowired
    private TestMapper testMapper;

    private Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Override
    public List<Test> list() {
        return testMapper.findAll();
    }

    @Override
    @TxTransaction(isStart = true)
    @Transactional
    public int save() {

        int rs1 = testMapper.save("mybatis-hello-1");

        int rs2 = demo2Client.save();

//        int rs22 = demo2Client.save();

        int v = 100/0;

        return rs1+rs2;
    }
}
