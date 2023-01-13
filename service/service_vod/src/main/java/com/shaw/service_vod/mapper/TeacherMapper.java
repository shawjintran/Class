package com.shaw.service_vod.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shaw.online.model.vod.Teacher;
import com.shaw.online.vo.vod.TeacherQueryVo;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
* @author sky
* @description 针对表【teacher(讲师)】的数据库操作Mapper
* @createDate 2023-01-12 18:32:02
* @Entity com.shaw.service_vod.entity.Teacher
*/
@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {

}




