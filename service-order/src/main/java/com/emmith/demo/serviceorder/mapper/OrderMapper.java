package com.emmith.demo.serviceorder.mapper;

import com.emmith.demo.serviceorder.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author emmith
 * @since 2022-06-21
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
