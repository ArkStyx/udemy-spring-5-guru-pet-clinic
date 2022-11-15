package udemy.spring5.guru.sfgpetclinic.services.maps.v2;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import udemy.spring5.guru.sfgpetclinic.models.BaseEntity;
import udemy.spring5.guru.sfgpetclinic.services.CrudService;

public abstract class AbstractMapServiceV2<T extends BaseEntity, ID extends Long> implements CrudService<T, ID> {

	protected Map<Long, T> map = new HashMap<>();

	@Override
	public Set<T> findAll() {
		return new HashSet<>(map.values());
	}
	
	@Override
	public T findById(ID id) {
		return map.get(id);
	}

	@Override
	public T save(T t) {
		if (t != null) {
			if (t.getId() == null) {
				t.setId(getNextId());
			}
			map.put(t.getId(), t);
		}
		else {
			throw new RuntimeException("T cannot be null");
		}
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
