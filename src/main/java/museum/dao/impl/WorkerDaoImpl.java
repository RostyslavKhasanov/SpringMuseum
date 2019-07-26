package museum.dao.impl;

import museum.dao.ElementDaoImpl;
import museum.dao.WorkerDao;
import museum.dto.worker.WorkerDto;
import museum.entity.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Repository
public class WorkerDaoImpl extends ElementDaoImpl<Worker> implements WorkerDao {
    public WorkerDaoImpl() {
        super(Worker.class);
    }

    @Autowired
    private EntityManager entityManager;

    @Override
    public Long findWorkerIdByName(String name) {
        String strQuery = "w.id from Worker w where lower(w.secondName) = lower(:name)";
        TypedQuery query = entityManager.createQuery(strQuery, Worker.class).setParameter("name", name);
        Long id = (Long) query.getSingleResult();
        return id;
    }
}
