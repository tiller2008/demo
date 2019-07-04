package com.example.demo;

public interface AService extends BaseConsumerService<A> {
    @Override
    String save(A a);
}
