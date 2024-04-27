package icu.yblog.ybblog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import icu.yblog.ybblog.entity.User;
import icu.yblog.ybblog.mapper.UserMapper;
import icu.yblog.ybblog.service.UserService;
import org.springframework.stereotype.Service;

import javax.management.monitor.Monitor;

/**
 * @author 旷丞吉
 * @title UserServiceImpl
 * @date 2023-11-10 22:41
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}