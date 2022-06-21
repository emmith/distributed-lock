package com.emmith.demo.serviceorder.service.impl;

import com.emmith.demo.serviceorder.entity.Order;
import com.emmith.demo.serviceorder.mapper.OrderMapper;
import com.emmith.demo.serviceorder.service.IOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author emmith
 * @since 2022-06-21
 */
@Service
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {
    @Resource
    OrderMapper orderMapper;

    @Override
    @SneakyThrows
    public boolean grab(int orderId, int driverId) {
        Order order = orderMapper.selectById(orderId);

        if (order.getOrderStatus().intValue() == 0) {
            order.setOrderStatus(1);
            order.setOrderDescription(String.format("司机%s 抢单成功", driverId));
            order.setDriverId(driverId);
            orderMapper.updateById(order);
            return true;
        }
        return false;
    }
}
