package com.shaw.service_vod.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shaw.online.model.vod.Subject;
import org.apache.ibatis.annotations.Mapper;

/**
* @author sky
* @description 针对表【subject(课程科目)】的数据库操作Mapper
* @createDate 2023-01-16 19:04:11
* @Entity com.shaw.service_vod.entity.Subject
*/
@Mapper
public interface SubjectMapper extends BaseMapper<Subject> {

}




