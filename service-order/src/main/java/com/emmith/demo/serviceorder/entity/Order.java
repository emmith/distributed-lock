package com.emmith.demo.serviceorder.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDate;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *
 * </p>
 *
 * @author emmith
 * @since 2022-06-21
 */
@Data
@TableName("tbl_order")
public class Order {

    @TableId("order_id")
    private Integer orderId;

    @TableField("order_status")
    private Integer orderStatus;

    @TableField("order_description")
    private String orderDescription;

    @TableField("driver_id")
    private Integer driverId;

    @TableField("update_time")
    private LocalDate updateTime;
}
