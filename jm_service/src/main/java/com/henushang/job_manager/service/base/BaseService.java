package com.henushang.job_manager.service.base;

public interface BaseService<T> {
	public boolean add(T t);

	public boolean delete(String id);

	public T getOne(String id);
	
	public boolean update(T t);
}
