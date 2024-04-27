package icu.yblog.ybblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import icu.yblog.ybblog.entity.Course;
import icu.yblog.ybblog.entity.TeacherInCourse;
import icu.yblog.ybblog.mapper.CourseMapper;
import icu.yblog.ybblog.mapper.TeacherInCourseMapper;
import icu.yblog.ybblog.service.CourseService;
import icu.yblog.ybblog.service.TeacherInCourseService;
import org.springframework.stereotype.Service;

/**
 * @author 旷丞吉
 * @title UserServiceImpl
 * @date 2023-11-10 22:41
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

}