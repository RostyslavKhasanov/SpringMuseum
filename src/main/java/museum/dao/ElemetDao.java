package museum.dao;

import java.util.List;

public interface ElemetDao<T> {
  List<T> findAll();

  T findById(Long id);

  void save(T element);

  void update(T element);

  void delete(T element);
}
