package museum.dao;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class ElementDaoImpl<T> implements ElementDao<T> {

  @PersistenceContext
  private EntityManager manager;

  private Class<T> elementClass;

  public ElementDaoImpl(Class<T> elementClass) {
    this.elementClass = elementClass;
  }

  @Override
  public List<T> findAll() {
    return manager
        .createQuery("from " + elementClass.getSimpleName() + " e", elementClass)
        .getResultList();
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
  public T update(T element) {
    return manager.merge(element);
  }

  @Override
  public Boolean deleteById(Long id) {
    T byId = findById(id);
    if (byId != null) {
      manager.remove(byId);
      return true;
    } else {
      return false;
    }
  }
}
