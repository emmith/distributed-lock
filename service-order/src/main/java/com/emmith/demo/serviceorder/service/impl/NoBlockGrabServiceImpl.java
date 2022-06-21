package com.emmith.demo.serviceorder.service.impl;

import com.emmith.demo.serviceorder.service.GrabService;
import com.emmith.demo.serviceorder.service.IOrderService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("noBlockGrabService")
@Slf4j
public class NoBlockGrabServiceImpl implements GrabService {

    @Resource
    IOrderService orderService;

    @Override
    @SneakyThrows
    public String grabOrder(int orderId, int driverId) {
        log.info("司机: {} 执行抢单逻辑", driverId);

        boolean grabRes = orderService.grab(orderId, driverId);
        if (grabRes) {
            log.info("司机: {} 抢单成功", driverId);
            return "success";
        } else {
            log.info("司机: {} 抢单失败", driverId);
        }

        return "failed";
    }
}
