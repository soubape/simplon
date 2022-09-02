package net.stc.management.services;

import java.util.List;

public interface StcServices<T>{
	
	public List<T>getAll();
    public T getById(Long t);
    public T save(T t);
    public void update(T t2, Long t1);
    public void delete(Long t3);

}
