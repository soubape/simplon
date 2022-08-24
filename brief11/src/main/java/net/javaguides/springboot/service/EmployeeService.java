package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;

public interface EmployeeService<T> {
	List<T> getAll();
	void save(T t);
	T getById(long id);
	void deleteById(long id);
	Page<T> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
