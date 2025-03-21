package com.feiniaojin.ddd.domain.entity;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * <p>TokenEntity</p>
 *
 * @author thy
 */
@Slf4j
@Getter
public class TokenEntity {
    private String token;
    private String name;
    private Integer id;

    public TokenEntity() {
    }


    public void setToken(String token) {
        if (StringUtils.isBlank(token)) {
            throw new RuntimeException();
        }
        this.token = token;
    }

    public void setId(Integer id) {
        if (Objects.isNull(id)) {
            throw new RuntimeException();
        }
        this.id = id;
    }

    public void setName(String name) {
        if (StringUtils.isBlank(name)) {
            throw new RuntimeException();
        }
        this.name = name;
    }

    public Integer auth() {
        log.info("鉴权通过");
        return id;
    }
}
