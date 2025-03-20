package com.feiniaojin.ddd.domain.repository;

import com.feiniaojin.ddd.domain.entity.TokenEntity;

/**
 * <p>TokenEntityRepository</p>
 *
 * @author thy
 */
public interface TokenEntityRepository {

    TokenEntity load(String token);

    void save(TokenEntity token);
}
