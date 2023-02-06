package com.shaw.service_order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shaw.online.model.order.OrderInfo;
import org.apache.ibatis.annotations.Mapper;

/**
* @author sky
* @description 针对表【order_info(订单表 订单表)】的数据库操作Mapper
* @createDate 2023-02-06 16:43:26
* @Entity com.shaw.service_order.entity.OrderInfo
*/
@Mapper
public interface OrderInfoMapper extends BaseMapper<OrderInfo> {

}




