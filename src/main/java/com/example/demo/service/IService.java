package com.example.demo.service;

import java.util.Optional;

public interface IService<T> {
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    T save(T model);
    void remove(Long id);
}

