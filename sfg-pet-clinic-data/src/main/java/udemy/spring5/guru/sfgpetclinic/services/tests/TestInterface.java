package udemy.spring5.guru.sfgpetclinic.services.tests;

import java.util.Set;

public interface TestInterface<T> {

	T findById(Long id);
	T save(T t);
	Set<T> findAll();
}
