package icu.yblog.ybblog.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;


@Data
public class AbnormalImg implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long tcid;
    private String imageUrl;
    private LocalDateTime createTime;

}