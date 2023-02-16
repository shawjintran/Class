package com.shaw.service_activity.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shaw.online.model.activity.CouponInfo;
import com.shaw.online.model.activity.CouponUse;
import com.shaw.online.vo.activity.CouponUseQueryVo;

/**
* @author sky
* @description 针对表【coupon_info(优惠券信息)】的数据库操作Service
* @createDate 2023-02-06 17:30:41
*/
public interface CouponInfoService extends IService<CouponInfo> {

	IPage<CouponUse> selectCouponUsePage(Page<CouponUse> pageParam, CouponUseQueryVo couponUseQueryVo);
}
