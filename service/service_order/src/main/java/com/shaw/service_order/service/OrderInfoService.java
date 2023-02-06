package com.shaw.service_order.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shaw.online.model.order.OrderInfo;
import com.shaw.online.vo.order.OrderInfoQueryVo;

import java.util.Map;

/**
* @author sky
* @description 针对表【order_info(订单表 订单表)】的数据库操作Service
* @createDate 2023-02-06 16:43:26
*/
public interface OrderInfoService extends IService<OrderInfo> {

	Map<String, Object> findPageOrderInfo(Page<OrderInfo> pageParam, OrderInfoQueryVo orderInfoQueryVo);
}
