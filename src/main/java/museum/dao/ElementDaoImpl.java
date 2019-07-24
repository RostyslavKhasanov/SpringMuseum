package museum.dao;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public class ElementDaoImpl<T> implements ElemetDao<T> {

    @Autowired
    private EntityManager manager;

    private Class<T> elementClass;

    public ElementDaoImpl(Class<T> elementClass) {
        this.elementClass = elementClass;
    }

    @Override
    public List<T> findAll() {
        manager.getTransaction().begin();
        List<T> resultList =
                manager
                        .createQuery("from " + elementClass.getSimpleName() + " e", elementClass)
                        .getResultList();
        manager.getTransaction().commit();
        return resultList;
    }

    @Override
    public T findById(Long id) {
        manager.getTransaction().begin();

        manager.getTransaction().commit();
        return null;
    }

    @Override
    public T save(T element) {
        manager.getTransaction().begin();
        manager.persist(element);
        manager.getTransaction().commit();
        return null;
    }

    @Override
    public T update(T element) {
        manager.getTransaction().begin();

        manager.getTransaction().commit();
        return null;
    }

    @Override
    public Boolean delete(T element) {
        manager.getTransaction().begin();

        manager.getTransaction().commit();
        return null;
    }
}
