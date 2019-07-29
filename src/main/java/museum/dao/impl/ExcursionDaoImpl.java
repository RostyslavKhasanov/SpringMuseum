package museum.dao.impl;

import museum.dao.ElementDaoImpl;
import museum.dao.ExcursionDao;
import museum.dto.response.excursion.ExcursionResponse;
import museum.entity.Excursion;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Repository
public class ExcursionDaoImpl extends ElementDaoImpl<Excursion> implements ExcursionDao {
  public ExcursionDaoImpl() {
    super(Excursion.class);
  }

  @PersistenceContext private EntityManager manager;

  @Override
  public List<ExcursionResponse> findByPeriod(LocalDateTime start, LocalDateTime end) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    String startTime = start.format(formatter);
    String endTime = end.format(formatter);
    String string = "from Excursion e where e.begin >= :startTime and e.end <= :endTime";
    Query query =
        manager
            .createQuery(string, Excursion.class)
            .setParameter("startTime", start)
            .setParameter("endTime", end);
    List<ExcursionResponse> excursions = query.getResultList();
    return excursions;
  }

  @Override
  public Integer findCountByPeriod(LocalDateTime start, LocalDateTime end) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    String startTime = start.format(formatter);
    String endTime = end.format(formatter);
    String string =
        "select count(*) from Excursion e where e.begin >= :startTime and e.end <= :endTime";
    TypedQuery<Long> query =
        manager
            .createQuery(string, Long.class)
            .setParameter("startTime", start)
            .setParameter("endTime", end);
    Long countL = query.getSingleResult();
    Integer count = countL.intValue();
    return count;
  }
}
