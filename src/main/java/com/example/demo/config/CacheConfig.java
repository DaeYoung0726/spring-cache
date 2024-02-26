package com.example.demo.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@EnableCaching  // 캐싱을 활성화
@Configuration
public class CacheConfig {

    /*@Bean
    public CacheManager cacheManager() {
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
        simpleCacheManager.setCaches(List.of(new ConcurrentMapCache("exampleStore"))); // addresses라는 이름의 캐시를 설정
        // 만약 여러개 캐시 저장소 저장하려면
        // simpleCacheManager.setCaches(List.of(new ConcurrentMapCache("exampleStore1"), new ConcurrentMapCache("exampleStore2")));
        // ConcurrentMapCache는 ConcurrentHashMap을 기반으로 동작.
        return simpleCacheManager;
        // 캐시는 일반적으로 key-value 형식으로 데이터를 저장하고 검색
    }*/

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager();
    }
}
