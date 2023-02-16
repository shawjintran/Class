package com.shaw.service_activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.shaw.online.model.user.UserInfo;
import com.shaw.online.model.activity.CouponInfo;
import com.shaw.online.model.activity.CouponUse;
import com.shaw.online.vo.activity.CouponUseQueryVo;
import com.shaw.service_activity.service.CouponInfoService;
import com.shaw.service_activity.mapper.CouponInfoMapper;
import com.shaw.service_activity.service.CouponUseService;
import com.shaw.service_user_client.UserInfoFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
* @author sky
* @description 针对表【coupon_info(优惠券信息)】的数据库操作Service实现
* @createDate 2023-02-06 17:30:41
*/
@Service
public class CouponInfoServiceImpl extends ServiceImpl<CouponInfoMapper, CouponInfo>
    implements CouponInfoService{


	@Autowired
	private CouponUseService couponUseService;

	@Autowired
	private UserInfoFeignClient userInfoFeignClient;

	//获取已使用优惠券列表
	@Override
	public IPage<CouponUse> selectCouponUsePage(Page<CouponUse> pageParam, CouponUseQueryVo couponUseQueryVo) {
		//获取条件
		Long couponId = couponUseQueryVo.getCouponId();
		String couponStatus = couponUseQueryVo.getCouponStatus();
		String getTimeBegin = couponUseQueryVo.getGetTimeBegin();
		String getTimeEnd = couponUseQueryVo.getGetTimeEnd();
		//封装条件
		QueryWrapper<CouponUse> wrapper = new QueryWrapper<>();
		if(!ObjectUtils.isEmpty(couponId)) {
			wrapper.eq("coupon_id",couponId);
		}
		if(!ObjectUtils.isEmpty(couponStatus)) {
			wrapper.eq("coupon_status",couponStatus);
		}
		if(!ObjectUtils.isEmpty(getTimeBegin)) {
			wrapper.ge("get_time",getTimeBegin);
		}
		if(!ObjectUtils.isEmpty(getTimeEnd)) {
			wrapper.le("get_time",getTimeEnd);
		}
		//调用方法查询
		IPage<CouponUse> page = couponUseService.page(pageParam, wrapper);
		//封装用户昵称和手机号
		List<CouponUse> couponUseList = page.getRecords();
		couponUseList.stream().forEach(item->{
			this.getUserInfoBycouponUse(item);
		});
		return page;
	}

	//封装用户昵称和手机号
	private CouponUse getUserInfoBycouponUse(CouponUse couponUse) {
		Long userId = couponUse.getUserId();
		if(!ObjectUtils.isEmpty(userId)) {
			UserInfo userInfo = userInfoFeignClient.getById(userId);
			if(userInfo != null) {
				couponUse.getParam().put("nickName", userInfo.getNickName());
				couponUse.getParam().put("phone", userInfo.getPhone());
			}
		}
		return couponUse;
	}
}




