package com.shaw.service_activity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shaw.online.model.activity.CouponInfo;
import org.apache.ibatis.annotations.Mapper;

/**
* @author sky
* @description 针对表【coupon_info(优惠券信息)】的数据库操作Mapper
* @createDate 2023-02-06 17:30:41
* @Entity com.shaw.service_activity.entity.CouponInfo
*/
@Mapper
public interface CouponInfoMapper extends BaseMapper<CouponInfo> {

}




