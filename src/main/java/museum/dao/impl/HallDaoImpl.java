package museum.dao.impl;

import museum.dao.ElementDaoImpl;
import museum.dao.HallDao;
import museum.entity.Hall;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Repository for Hall logic.
 *
 * @author Kateryna Horokh
 * @version 1.0
 */
@Repository
public class HallDaoImpl extends ElementDaoImpl<Hall> implements HallDao {
  public HallDaoImpl() {
    super(Hall.class);
  }

  @PersistenceContext
  private EntityManager manager;

  /** Method that find hall by worker id.
   *
   * @param workerId
   * @return List of HallDtoResponse.
   * */
  @Override
  public List<Hall> findHalLByWorkerId(Long workerId) {
    String qry = "from Hall h where h.worker.id = :worker_Id";
    TypedQuery query = manager.createQuery(qry, Hall.class).setParameter("worker_Id", workerId);
    List<Hall> hall = query.getResultList();
    return hall;
  }
}
