package com.feiniaojin.ddd.domain.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

/**
 * <p>UserEntity</p>
 *
 * @author thy
 */
@Slf4j
@Data
public class UserEntity {

    private Integer id;

    private String name;

    private String password;

    private LocalDateTime createDate;

    public void register() {
        // 处理其他逻辑
        log.info("用户 {} 已注册", this.name);
    }
}
