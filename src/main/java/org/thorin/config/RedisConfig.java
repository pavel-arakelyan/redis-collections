package org.thorin.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.codec.Kryo5Codec;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author pavel.arakelyan
 */
@Configuration
public class RedisConfig {

	@Bean
	Config redissonConfiguration(
			@Value("${redis.host}") String host,
			@Value("${redis.port}") String port,
			@Value("${redis.password}") String password,
			@Value("${redis.maxPoolSize}") Integer maxPoolSize,
			@Value("${redis.minIdleSize}") Integer minIdleSize,
			@Value("${redis.requestTimeout}") Integer requestTimeout
	) {
		Config redissonCfg = new Config();
		redissonCfg
				.setCodec(new Kryo5Codec())
				.useSingleServer()
				.setTimeout(requestTimeout)
				.setConnectionMinimumIdleSize(minIdleSize)
				.setConnectionPoolSize(maxPoolSize)
				.setPassword(password)
				.setAddress("redis://" + host + ":" + port);
		return redissonCfg;
	}

	@Bean
	@Autowired
	RedissonClient redissonClient(Config config) {
		return Redisson.create(config);
	}

}
