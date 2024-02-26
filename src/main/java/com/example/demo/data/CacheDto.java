package com.example.demo.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CacheDto {
    
    private Long id;
    private String name;
    private int age;
    
    
}
