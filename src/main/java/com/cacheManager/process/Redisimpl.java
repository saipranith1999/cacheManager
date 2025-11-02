package com.cacheManager.process;

import io.lettuce.core.api.sync.RedisCommands;
import io.micronaut.serde.ObjectMapper;

public class Redisimpl {

    private final RedisCommands<String,String> redisCommands;

    private final ObjectMapper objectMapper;
    public Redisimpl(RedisCommands<String, String> redisCommands, ObjectMapper objectMapper) {
        this.redisCommands = redisCommands;
        this.objectMapper = objectMapper;
    }

    public <T> void saveToRedis(String key, T value) throws Exception {
        String jsonValue = objectMapper.writeValueAsString(value);
        redisCommands.set(key, jsonValue);
    }
}
