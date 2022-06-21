package com.emmith.demo.serviceorder.controller;

import com.emmith.demo.serviceorder.service.GrabService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/grab")
@Slf4j
public class GrabController {

    @Resource(name = "jvmLockGrabService")
    GrabService grabService;

    @GetMapping("/do/{orderId}")
    public String grabMysql(@PathVariable("orderId") int orderId, int driverId) {
        log.info("order: {}, driverId: {}", orderId, driverId);
        String res = grabService.grabOrder(orderId, driverId);
        return res;
    }
}
