package com.example.demo;

public interface BaseConsumerService<T extends AbstractBaseDomain> {
    String save(T t);
}
