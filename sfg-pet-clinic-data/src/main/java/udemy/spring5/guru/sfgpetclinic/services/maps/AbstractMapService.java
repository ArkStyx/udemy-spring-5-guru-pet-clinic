package udemy.spring5.guru.sfgpetclinic.services.maps;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import udemy.spring5.guru.sfgpetclinic.models.BaseEntity;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

	protected Map<Long, T> map = new HashMap<>();
	
	Set<T> findAll() {
		return new HashSet<>(map.values());
	}
	
	T findById(ID id) {
		return map.get(id);
	}
	
	T save(T object) {
		if (object != null) {
			if (object.getId() == null) {
				object.setId(getNextId());
			}
			map.put(object.getId(), object);
		}
		else {
			throw new RuntimeException("Object cannot be null");
		}
		return object;
	}
	
	void deleteById(ID id) {
		map.remove(id);
	}

	void delete(T object) {
		map.entrySet().removeIf(entry -> entry.getValue().equals(object));
	}
	
	private Long getNextId() {
		Long prochainId = null;
		try {
			prochainId = Collections.max(map.keySet()) + 1;
		} catch (NoSuchElementException e) {
			prochainId = 1L;
		}
		return prochainId;
	}
}
