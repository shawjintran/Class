package com.shaw.service_order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shaw.online.model.order.OrderDetail;
import com.shaw.service_order.service.OrderDetailService;
import com.shaw.service_order.mapper.OrderDetailMapper;
import org.springframework.stereotype.Service;

/**
* @author sky
* @description 针对表【order_detail(订单明细 订单明细)】的数据库操作Service实现
* @createDate 2023-02-06 16:43:26
*/
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail>
    implements OrderDetailService{

}




