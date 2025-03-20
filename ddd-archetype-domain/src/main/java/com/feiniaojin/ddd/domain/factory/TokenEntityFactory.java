package com.feiniaojin.ddd.domain.factory;


import com.feiniaojin.ddd.domain.entity.TokenEntity;

/**
 * <p>UserEntityFactory</p>
 *
 * @author thy
 */
public interface TokenEntityFactory {
    TokenEntity newInstance(String name, String token);
}
