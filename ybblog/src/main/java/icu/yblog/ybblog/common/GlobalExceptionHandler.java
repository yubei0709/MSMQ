package icu.yblog.ybblog.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**全局异常处理器
 */
@ControllerAdvice(annotations = {RestController.class, Controller.class})
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 异常处理异常
     * @return
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public R<String> exception(SQLIntegrityConstraintViolationException e){
        log.info(e.getMessage());
        //判断异常是否包含某个字段
        if (e.getMessage().contains(("Duplicate entry"))){
            //拿到异常信息进行处理
            String[] s = e.getMessage().split(" ");
            String msg = s[2]+"用户名已存在-_-!";
            return R.error(msg);
        }
        return R.error("未知错误");
    }

    /**
     * 自定义异常
     * @param e
     * @return
     */
    @ExceptionHandler(CustomExcetion.class)
    public R<String> exception(CustomExcetion e){
        log.info("CustomExcetion:",e.getMessage());
//        log.info(e.getMessage().split(" ").toString());
        return R.error(e.getMessage());
    }
}