package com.emmith.demo.serviceorder.controller;

import com.emmith.demo.serviceorder.entity.Order;
import com.emmith.demo.serviceorder.service.IOrderService;
import kotlin.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author emmith
 * @since 2022-06-21
 */
@RestController
@RequestMapping("/serviceorder/order")
public class OrderController {

    @Resource
    IOrderService orderService;

    @GetMapping("/haha")
    public List<Order> findAll() {
        List<Order> list = orderService.list();
        return list;
    }
}
