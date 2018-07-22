package com.example.demo.drivers;

public interface Resolver<T, P> {
    T resolve(P payload);
}
