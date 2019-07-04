package com.example.demo;

public interface Factory<T> {
    T create(String cause);
}
