<<<<<<< HEAD
package gt.edu.umg.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IGenericRepository<T, ID> extends JpaRepository<T, ID> {

	default T guardar(T entidad) {
		return save(entidad);
	}

	default List<T> obtenerTodos() {
		return findAll();
	}

	default Optional<T> obtenerPorId(ID id) {
		return findById(id);
	}

	default void eliminarPorId(ID id) {
		deleteById(id);
	}
}
=======
package gt.edu.umg.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IGenericRepository<T, ID> extends JpaRepository<T, ID> {

	default T guardar(T entidad) {
		return save(entidad);
	}

	default List<T> obtenerTodos() {
		return findAll();
	}

	default Optional<T> obtenerPorId(ID id) {
		return findById(id);
	}

	default void eliminarPorId(ID id) {
		deleteById(id);
	}
}
>>>>>>> ffcf5a27d8dc35521b8fa58bbb4e95f6aef4e943
