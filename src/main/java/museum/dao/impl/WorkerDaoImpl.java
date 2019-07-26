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
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class WorkerDaoImpl extends ElementDaoImpl<Worker> implements WorkerDao {
    public WorkerDaoImpl() {
        super(Worker.class);
    }

    @Autowired
    private EntityManager entityManager;

    @Override
    public Long findWorkerIdByName(String name) {
        String strQuery = "select w.id from Worker w where lower(w.secondName) = lower(:name)";
        TypedQuery query = entityManager.createQuery(strQuery, Long.class).setParameter("name", name);
        Long id = (Long) query.getSingleResult();
        return id;
    }

    @Override
    public List<WorkerDto> findAllFreeGuide(LocalDateTime date) {
        String strQuery = "select w from  Worker w join Excursion e on e.worker.id = w.id where w.id not in" +
                "(select e.worker.id from Excursion e where e.begin < :date and e.end > :date) group by w.id";
        TypedQuery query = entityManager.createQuery(strQuery, Worker.class).setParameter("date", date);
        List<WorkerDto> workerDtos = query.getResultList();
        return workerDtos;
    }

    @Override
    public List<WorkerDto> findAllGuide() {
        String strQuery = "select w from Worker w join Post p on p.id = w.post.id where p.name = 'gid'";
        TypedQuery query = entityManager.createQuery(strQuery, Worker.class);
        List<WorkerDto> workerDtos = query.getResultList();
        return workerDtos;
    }
}
