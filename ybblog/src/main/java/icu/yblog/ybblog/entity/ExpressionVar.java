package icu.yblog.ybblog.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
public class ExpressionVar implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long tcid;
    private int anger;
    private int disgust;
    private int fear;
    private int happy;
    private int sad;
    private int surprised;
    private int normal;
    private LocalDateTime createTime;

}