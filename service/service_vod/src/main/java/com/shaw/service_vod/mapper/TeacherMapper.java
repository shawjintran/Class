package com.shaw.service_vod.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shaw.online.model.vod.Teacher;
import org.apache.ibatis.annotations.Mapper;

/**
* @author sky
* @description 针对表【teacher(讲师)】的数据库操作Mapper
* @createDate 2023-01-12 18:32:02
* @Entity com.shaw.service_vod.entity.Teacher
*/
@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {

}




