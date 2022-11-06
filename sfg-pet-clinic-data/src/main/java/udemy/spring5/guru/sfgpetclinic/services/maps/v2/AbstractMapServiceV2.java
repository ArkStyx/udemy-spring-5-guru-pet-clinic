package udemy.spring5.guru.sfgpetclinic.services.maps.v2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import udemy.spring5.guru.sfgpetclinic.services.v2.CrudServiceV2;

public abstract class AbstractMapServiceV2<T, ID> implements CrudServiceV2<T, ID> {

	protected Map<ID, T> map = new HashMap<>();

	@Override
	public Set<T> findAll() {
		return new HashSet<>(map.values());
	}
	
	@Override
	public T findById(ID id) {
		return map.get(id);
	}

	@Override
	public T save(ID id, T t) {
		map.put(id, t);
		return t;
	}

	@Override
	public void delete(T t) {
		map.entrySet().removeIf(entry -> entry.getValue().equals(t));
	}

	@Override
	public void deleteById(ID id) {
		map.remove(id);
	}
	
}
