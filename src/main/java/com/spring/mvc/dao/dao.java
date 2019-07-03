package com.spring.mvc.dao;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface dao {
    List<Map> list(String id);
}
