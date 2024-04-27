package icu.yblog.ybblog.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
public class AttentionZyl implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long tcid;
    private int value;
    private LocalDateTime createTime;

}