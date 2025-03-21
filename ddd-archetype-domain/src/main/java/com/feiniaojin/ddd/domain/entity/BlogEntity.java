package com.feiniaojin.ddd.domain.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

/**
 * <p>BlogEntity</p>
 *
 * @author thy
 */
@Slf4j
@Data
public class BlogEntity {
    private Integer id;
    private String title;
    private String content;
    private Integer userId;
    private LocalDateTime createDate;
    private Integer status;

    public void publish() {
        status = 1;
        createDate = LocalDateTime.now();
        log.info("发布博文");
    }
}
