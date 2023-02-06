package com.shaw.service_order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shaw.online.model.order.OrderDetail;
import com.shaw.online.model.order.OrderInfo;
import com.shaw.online.vo.order.OrderInfoQueryVo;
import com.shaw.service_order.service.OrderDetailService;
import com.shaw.service_order.service.OrderInfoService;
import com.shaw.service_order.mapper.OrderInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author sky
* @description 针对表【order_info(订单表 订单表)】的数据库操作Service实现
* @createDate 2023-02-06 16:43:26
*/
@Service
public class OrderInfoServiceImpl extends ServiceImpl<OrderInfoMapper, OrderInfo>
    implements OrderInfoService{
	@Autowired
	OrderDetailService detailService;
	@Override
	public Map<String, Object> findPageOrderInfo(Page<OrderInfo> pageParam, OrderInfoQueryVo orderInfoQueryVo) {
		//orderInfoQueryVo获取查询条件
		Long userId = orderInfoQueryVo.getUserId();
		String outTradeNo = orderInfoQueryVo.getOutTradeNo();
		String phone = orderInfoQueryVo.getPhone();
		String createTimeEnd = orderInfoQueryVo.getCreateTimeEnd();
		String createTimeBegin = orderInfoQueryVo.getCreateTimeBegin();
		Integer orderStatus = orderInfoQueryVo.getOrderStatus();

		//判断条件值是否为空，不为空，进行条件封装
		QueryWrapper<OrderInfo> wrapper = new QueryWrapper<>();
		if(!ObjectUtils.isEmpty(orderStatus)) {
			wrapper.eq("order_status",orderStatus);
		}
		if(!ObjectUtils.isEmpty(userId)) {
			wrapper.eq("user_id",userId);
		}
		if(!ObjectUtils.isEmpty(outTradeNo)) {
			wrapper.eq("out_trade_no",outTradeNo);
		}
		if(!ObjectUtils.isEmpty(phone)) {
			wrapper.eq("phone",phone);
		}
		if(!ObjectUtils.isEmpty(createTimeBegin)) {
			wrapper.ge("create_time",createTimeBegin);
		}
		if(!ObjectUtils.isEmpty(createTimeEnd)) {
			wrapper.le("create_time",createTimeEnd);
		}
		//调用实现条件分页查询
		Page<OrderInfo> pages = baseMapper.selectPage(pageParam, wrapper);
		long totalCount = pages.getTotal();
		long pageCount = pages.getPages();
		List<OrderInfo> records = pages.getRecords();
		//订单里面包含详情内容，封装详情数据，根据订单id查询详情
		records.stream().forEach((item) -> {
			this.getOrderDetail(item);
		});

		//所有需要数据封装map集合，最终返回
		Map<String,Object> map = new HashMap<>();
		map.put("total",totalCount);
		map.put("pageCount",pageCount);
		map.put("records",records);
		return map;
	}
	//查询订单详情数据
	private OrderInfo getOrderDetail(OrderInfo orderInfo) {
		//订单id
		Long id = orderInfo.getId();
		//查询订单详情
		OrderDetail orderDetail = detailService.getById(id);
		if(orderDetail != null) {
			String courseName = orderDetail.getCourseName();
			orderInfo.getParam().put("courseName",courseName);
		}
		return orderInfo;
	}
}




