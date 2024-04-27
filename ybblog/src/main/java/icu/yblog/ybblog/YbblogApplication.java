package icu.yblog.ybblog;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@Slf4j
@SpringBootApplication
@ServletComponentScan

public class YbblogApplication{
//客户端
    public static void main(String[] args) {
        SpringApplication.run(YbblogApplication.class, args);
        log.info("请访问：http://localhost:8081/static/index.html");
    }
//public class YbblogApplication extends SpringBootServletInitializer {
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(YbblogApplication.class);
//    }
//
//    public static void main(String[] args) {
//        SpringApplication.run(YbblogApplication.class, args);
//    }

}
