package com.example.teamb4spring.service;

import java.util.List;

public interface BaseService<T, ID> {
	T create(T item);

	List<T> createAll(List<T> items);

	List<T> createAll(T... items);

	void update(T item);

	void delete(T item);

	void deleteById(ID id);

	T get(ID id);

	boolean exists(T item);

	List<T> findAll();
}
