package museum.dao.impl;

import museum.dao.ElementDaoImpl;
import museum.dao.WorkerDao;
import museum.dto.response.worker.WorkerDto;
import museum.entity.Worker;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class WorkerDaoImpl extends ElementDaoImpl<Worker> implements WorkerDao {
  public WorkerDaoImpl() {
    super(Worker.class);
  }

  @PersistenceContext
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
    String strQuery =
        "select w from  Worker w join Excursion e on e.worker.id = w.id where w.id not in"
            + "(select e.worker.id from Excursion e where e.begin < :date and e.end > :date) group by w.id";
    TypedQuery query = entityManager.createQuery(strQuery, Worker.class).setParameter("date", date);
    List<WorkerDto> workerDtos = query.getResultList();
    return workerDtos;
  }

  @Override
  public List<Worker> findAllGuide() {
    String strQuery = "select w from Worker w join Post p on p.id = w.post.id where p.name = 'gid'";
    TypedQuery query = entityManager.createQuery(strQuery, Worker.class);
    List<Worker> workerDtos = query.getResultList();
    return workerDtos;
  }

  @Transactional
  @Override
  public Integer findCountOfExcursion(Long id) {
    String strQuery =
        "select count(e) from Excursion e where e.worker.id = :id group by e.worker.id";
    TypedQuery<Long> query =
        entityManager.createQuery(strQuery, Long.class).setParameter("id", id);
    Long countL = query.getSingleResult();
    Integer count = countL.intValue();
    return count;
  }

  @Transactional
  @Override
  public Integer findCountOfHours(Long id) {
    String strQuery =
        "select sum(hour(timediff(e.begin, e.end))) from excursion e "
            + "join worker w on w.id = e.worker_id where e.worker_id = ? group by e.worker_id";
    Query query =
            entityManager
                .createNativeQuery(strQuery)
                .setParameter(1, id);
     BigDecimal countB = (BigDecimal) query.getSingleResult();
     Integer count = countB.intValue();
    return count;
  }
}
