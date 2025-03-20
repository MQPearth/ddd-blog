package com.feiniaojin.ddd.infrastructure.cache;

import com.feiniaojin.ddd.domain.entity.TokenEntity;
import com.feiniaojin.ddd.domain.repository.TokenEntityRepository;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>TokenEntityRepositoryImpl</p>
 *
 * @author thy
 */
@Component
public class TokenEntityRepositoryImpl implements TokenEntityRepository {

    /**
     * 可以用redis代替
     */
    public static final Map<String, TokenEntity> CACHE = new ConcurrentHashMap<>();

    @Override
    public TokenEntity load(String token) {
        return CACHE.get(token);
    }

    @Override
    public void save(TokenEntity token) {
        CACHE.put(token.getToken(), token);
    }
}
