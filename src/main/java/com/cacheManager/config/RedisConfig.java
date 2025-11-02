package com.cacheManager.config;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisConnectionException;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import io.lettuce.core.protocol.RedisCommand;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Value;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.core.type.Argument;
import io.micronaut.json.JsonStreamConfig;
import io.micronaut.json.tree.JsonNode;
import io.micronaut.serde.ObjectMapper;
import jakarta.inject.Singleton;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static io.micronaut.runtime.Micronaut.build;

@Factory
public class RedisConfig {

    @Value("${redis.host}")
    private String redisHost;

    @Value("${redis.port}")

    private String redisPort;

    @Value("${redis.password}")

    private String redisPassword;

    @Value("${redis.ssl}")

    private boolean redisssl;

    @Bean
    public StatefulRedisConnection<String, String> redisConnection() {

        RedisURI redisuri = RedisURI.builder()

                .withHost(redisHost)

                .withPort(Integer.parseInt(redisPort))

                .withPassword(redisPassword.toCharArray())

                .withSsl(redisssl).build();

        RedisClient redisClient = null;

        try {

            redisClient = RedisClient.create(redisuri);

            return redisClient.connect();

        } catch (RedisConnectionException e) {

            e.printStackTrace();

            throw new RuntimeException("Unable to connect to Redis server", e);

        }

    }

//    @Bean
//    public ObjectMapper objectMapper() {
//        return new ObjectMapper();
//
//    }
    @Singleton
    public RedisCommands<String,String> redisCommand(StatefulRedisConnection<String,String> redisConnection){
        return redisConnection.sync();
    }
}
