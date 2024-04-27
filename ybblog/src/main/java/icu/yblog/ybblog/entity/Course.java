package icu.yblog.ybblog.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private String className;
    private LocalDateTime createTime;
    private LocalDateTime updataTime;
}