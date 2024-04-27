package icu.yblog.ybblog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import icu.yblog.ybblog.entity.Course;
import icu.yblog.ybblog.entity.TeacherInCourse;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author 旷丞吉
 * @title UserMapper
 * @date 2023-11-10 22:40
 */
@Mapper
public interface TeacherInCourseMapper extends BaseMapper<TeacherInCourse> {
}