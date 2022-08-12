package dao;

import java.util.List;

public interface DaoService<O>{

	public void add(O o);
	public void update(O o);
	public List<O> list();
	public O getOById(int id);
	public void removeO(int id);
}
