package icu.yblog.ybblog.common;

/**自定义业务异常
 */
public class CustomExcetion extends RuntimeException{
    public CustomExcetion(String message){
        super(message);
    }
}