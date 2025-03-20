package com.feiniaojin.ddd.domain.entity;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * <p>TokenEntity</p>
 *
 * @author thy
 */
@Getter
public class TokenEntity {
    private String token;
    private String name;

    public TokenEntity() {
    }


    public void setToken(String token) {
        if (StringUtils.isBlank(token)) {
            throw new RuntimeException();
        }
        this.token = token;
    }


    public void setName(String name) {
        if (StringUtils.isBlank(name)) {
            throw new RuntimeException();
        }
        this.name = name;
    }
}
