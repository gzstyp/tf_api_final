package com.fwtai.controller;

import com.fwtai.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserServiceImpl userService;

    /**
     * 简单测试提交分布式事务接口，[[[在全局事务调用者(发起全局事务的服务)的接口上加入@GlobalTransactional 即可.]]]
     * 
     * @return
     */
    // http://127.0.0.1:8081/test/seataCommit
    @GetMapping(value = "seataCommit")
    public Boolean seataCommit() {
        userService.seataCommit();
        return true;
    }
}
