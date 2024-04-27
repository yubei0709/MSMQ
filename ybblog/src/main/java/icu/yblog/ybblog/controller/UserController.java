package icu.yblog.ybblog.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import freemarker.template.TemplateException;
import icu.yblog.ybblog.common.R;
import icu.yblog.ybblog.entity.Course;
import icu.yblog.ybblog.entity.TeacherInCourse;
import icu.yblog.ybblog.entity.User;
import icu.yblog.ybblog.service.CourseService;
import icu.yblog.ybblog.service.TeacherInCourseService;
import icu.yblog.ybblog.service.UserService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private TeacherInCourseService teacherInCourseService;

    @Value("${fileimage.path}")
    private String policyPath;

    /**
     * 用户登录
     *
     * @param request
     * @param user
     * @return
     */
    @PostMapping("/login")
    public R<User> loginUser(HttpServletRequest request, @RequestBody User user) {
        //用户名进行查询
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getUsername, user.getUsername())
                .eq(User::getPassword,user.getPassword());
        User userBy = userService.getOne(userLambdaQueryWrapper);
        //判断是否存在该用户
        if (userBy == null) {
            return R.error("工号/密码错误或无权限");
        }
        //验证通过
        request.getSession().setAttribute("user", userBy.getId());
        return R.success(userBy);
    }
    @GetMapping("/courseList")
    public R<List<Course>> courseList(HttpServletRequest request) {
        Long userId = (Long) request.getSession().getAttribute("user");
        LambdaQueryWrapper<TeacherInCourse> tcWrapper = new LambdaQueryWrapper<>();
        tcWrapper.eq(TeacherInCourse::getUid,userId);
        List<TeacherInCourse> list = teacherInCourseService.list(tcWrapper);
        List<Course> courseList = new ArrayList<>();
        for (TeacherInCourse teacherInCourse : list) {
            Course course = courseService.getById(teacherInCourse.getCid());
            courseList.add(course);
        }
        return R.success(courseList);
    }

    /**
     * 退出系统
     *
     * @param request
     * @return
     */
    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request) {
        //清理session
        request.getSession().removeAttribute("user");
        return R.success("退出成功");
    }



}