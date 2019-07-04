package com.example.demo;

public abstract class AbstractFactory<S extends BaseConsumerService<T>, T extends AbstractBaseDomain> implements Factory<S> {

    @Override
    public S create(String cause) {
        return (S) newInstance();
    }

    private BaseConsumerService<T> newInstance(){
        return new BaseConsumerService<T>() {
            @Override
            public String save(T t) {
                return "123";
            }
        };
    }
}
