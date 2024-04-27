package icu.yblog.ybblog.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
public class QualityScore implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long tcid;
    private int score;
    private LocalDateTime createTime;

}