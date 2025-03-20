package com.feiniaojin.ddd.domain.entity;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

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

    /**
     * 充血模型 实现具体业务逻辑, 领域模型的查询和保存接口定义在领域层, 具体实现在基础设施层
     */
    public String login(String inputPassword) {
        if (!Objects.equals(password, inputPassword)) {
            throw new RuntimeException("密码错误");
        }
        // 返回到应用层, 让其协调用infrastructure层存储token
        return UUID.randomUUID().toString();
    }
}
