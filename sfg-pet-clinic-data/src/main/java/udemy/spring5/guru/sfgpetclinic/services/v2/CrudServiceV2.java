package udemy.spring5.guru.sfgpetclinic.services.v2;

import java.util.Set;

public interface CrudServiceV2<T, ID> {

	T findById(ID id);
	
	T save(ID id, T t);
	
	Set<T> findAll();
	
	void delete(T t);
	
	void deleteById(ID id);
}
