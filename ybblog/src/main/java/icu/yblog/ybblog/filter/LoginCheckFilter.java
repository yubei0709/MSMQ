package icu.yblog.ybblog.filter;

import com.alibaba.fastjson.JSON;
import icu.yblog.ybblog.common.BaseContext;
import icu.yblog.ybblog.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户登录过滤器
 *
 * @author 旷丞吉
 * @title LoginCheckFilter
 * @date 2023-08-04 12:17
 */
@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {
    //路径匹配器，支持通配符
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        log.info("拦截请求：{}", request.getRequestURI());
        //获取url
        String requestURI = request.getRequestURI();
        //不需要处理的路径集合
        String[] urls = new String[]{
                "/user/**",
                "/static/**",
                "/img/**"
        };
        if ("/".equals(requestURI)) {
            log.info("首页请求");
            response.sendRedirect("/static/index.html");
            return;
        }
        //判断是否需要处理
        boolean check = check(urls, requestURI);
        if (check) {
            log.info("本次请求{}不需要处理", requestURI);
            //不需要处理直接放行
            filterChain.doFilter(request, response);
            return;
        }
        //判断需要处理--获取session
        if (request.getSession().getAttribute("user") != null) {
            log.info("用户已登录{}不需要处理，用户信息：{}", requestURI, request.getSession().getAttribute("user"));
            //获取线程id
//            long id = Thread.currentThread().getId();
//            log.info("过滤器：{}",id);
            //存储用户id
            Long empId = (Long) request.getSession().getAttribute("user");
            BaseContext.setCurrentId(empId);
            //已经登录放行
            filterChain.doFilter(request, response);
            return;
        }
        log.info("用户没有登录{}", requestURI);
        //没有登录，结合前端进行返回值处理，通过输出流像客户端进行响应
        response.sendRedirect("/static/index.html");
    }

    /**
     * 路径匹配校验
     *
     * @param urls
     * @param requestURI
     * @return
     */
    public boolean check(String[] urls, String requestURI) {
        for (String url : urls) {
            //进行匹配校验
            boolean match = PATH_MATCHER.match(url, requestURI);
            if (match) {
                //匹配成功
                return true;
            }
        }
        return false;
    }
}