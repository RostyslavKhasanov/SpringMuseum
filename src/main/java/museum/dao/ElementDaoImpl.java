package museum.dao;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public class ElementDaoImpl<T> implements ElemetDao<T> {

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
    return manager.find(elementClass, id);
  }

  @Override
  public void save(T element) {
    manager.persist(element);
  }

  @Override
  public void update(T element) {
    manager.merge(element);
  }

  @Override
  public void delete(T element) {
    manager.remove(element);
  }
}
