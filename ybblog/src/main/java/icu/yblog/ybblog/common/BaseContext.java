package icu.yblog.ybblog.common;

/*
基于ThreadLocal进行封装的类，用于保存和获取用户id
 */
public class BaseContext {
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<Long>();
    //保存值
    public static void setCurrentId(Long id) {
        threadLocal.set(id);
    }
    //获取值
    public static Long getCurrentId() {
        return threadLocal.get();
    }
}