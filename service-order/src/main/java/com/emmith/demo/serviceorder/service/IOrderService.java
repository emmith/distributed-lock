package com.emmith.demo.serviceorder.service;

import com.emmith.demo.serviceorder.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author emmith
 * @since 2022-06-21
 */
public interface IOrderService extends IService<Order> {
    boolean grab(int orderId, int driverId);
}
