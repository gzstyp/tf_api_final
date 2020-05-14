package com.fwtai.service.impl;

import com.fwtai.service.ITestService;
import io.seata.spring.annotation.GlobalTransactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2020-05-14 12:18
 * @QQ号码 444141300
 * @Email service@yinlz.com
 * @官网 <url>http://www.yinlz.com</url>
*/
@Service
public class UserServiceImpl {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ITestService iTestService;

    // 在全局事务调用者(发起全局事务的服务)的接口上加入@GlobalTransactional 即可
    @GlobalTransactional
    public Boolean seataCommit() {
        iTestService.commit();
        int i=1/0;
        return true;
    }
}