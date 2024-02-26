package com.example.demo.service;

import com.example.demo.data.CacheData;
import com.example.demo.repository.CacheRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CacheService {

    private final CacheRepository cacheRepository;


    @Transactional
    public void save(CacheData cacheData) {
        cacheRepository.save(cacheData);
    }

    @Transactional(readOnly = true)
    @Cacheable(value = "exampleStore")
    public List<CacheData> findAll() {
        return cacheRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Cacheable(value = "exampleStore", key = "#id")
    public CacheData findById(Long id) {
        return cacheRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Cacheable(value = "exampleStore1", key = "#name")
    public CacheData findById2(String name) {
        return cacheRepository.findByName(name);
    }

    @Transactional
    @CachePut(value = "exampleStore", key = "#id")      // 업데이트할 떄 사용.
    public CacheData update(Long id, CacheData updateData) {
        CacheData cacheData = cacheRepository.findById(id).orElse(null);
        cacheData.setName(updateData.getName());
        cacheData.setAge(updateData.getAge());
        return cacheRepository.save(cacheData);   // CachePut은 메서드의 반환 값을 캐시에 저장하는 것이 아니라 메서드 자체가 캐시를 업데이트하는 역할
                                                    // 그래서, 값을 return 해줘야함.
    }

    @Transactional
    @CacheEvict(value = "exampleStore", allEntries = true)      // 모든 캐시에서 내용 삭제. 그리고, exampleStore 이공간에 캐시 초기화.
    public void delete1(Long id) {
        this.cacheRepository.deleteById(id);
    }

    @Transactional
    @CacheEvict(value  = "exampleStore", key = "#id")       // exampleStore 공간 캐시 초기화
    public void delete2(Long id) {
        this.cacheRepository.deleteById(id);
    }

}
