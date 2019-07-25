package museum.dao;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public class ElementDaoImpl<T> implements ElementDao<T> {

  @Autowired private EntityManager manager;

  private Class<T> elementClass;

  public ElementDaoImpl(Class<T> elementClass) {
    this.elementClass = elementClass;
  }

  @Override
  public List<T> findAll() {
    List<T> resultList =
        manager
            .createQuery("from " + elementClass.getSimpleName() + " e", elementClass)
            .getResultList();
    return resultList;
  }

  @Override
  public T findById(Long id) {
    T t = manager.find(elementClass, id);
    return t;
  }

  @Override
  public void save(T element) {
    manager.persist(element);
  }

  @Override
  public T update(T element) {
    T merge = manager.merge(element);
    return merge;
  }

  @Override
  public void delete(T element) {
    manager.remove(element);
  }
}
