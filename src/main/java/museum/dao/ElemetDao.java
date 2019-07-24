package museum.dao;

import java.util.List;

public interface ElemetDao<T> {
  List<T> findAll();

  T findById(Long id);

  T save(T element);

  T update(T element);

  Boolean delete(T element);
}
