package com.example.demo.controller;

import com.example.demo.data.CacheData;
import com.example.demo.service.CacheService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class CacheController {

    private final CacheService cacheService;

    @PostMapping("/add")
    public void add(@RequestBody CacheData cacheData) {
        cacheService.save(cacheData);
    }

    @GetMapping("/data")
    public List<CacheData> findAll() {
        log.info("use Cache - findAll()");
        return cacheService.findAll();
    }

    @GetMapping("/data/{id}")
    public CacheData findById1(@PathVariable("id") Long id) {
        log.info("use Cache - findById()");
        return cacheService.findById(id);
    }

    @GetMapping("/data1/{name}")
    public CacheData findById2(@PathVariable("name") String name) {
        log.info("use Cache - findById()");
        return cacheService.findById2(name);
    }

    @PostMapping("/data/{id}/update")
    public void update(@PathVariable("id") Long id, @RequestBody CacheData cacheData) {
        cacheService.update(id, cacheData);
        log.info("update id = {}", id);
    }

    @DeleteMapping("/data/{id}/delete1")
    public void delete1(@PathVariable("id") Long id) {
        cacheService.delete1(id);
        log.info("delete1 id = {}", id);
    }

    @DeleteMapping("/data/{id}/delete2")
    public void delete2(@PathVariable("id") Long id) {
        cacheService.delete1(id);
        log.info("delete2 id = {}", id);
    }
}
