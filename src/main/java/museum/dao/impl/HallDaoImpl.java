package museum.dao.impl;

import museum.dao.ElementDaoImpl;
import museum.dao.HallDao;
import museum.dto.hall.response.HallResponse;
import museum.entity.Hall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class HallDaoImpl extends ElementDaoImpl<Hall> implements HallDao {
  public HallDaoImpl() {
    super(Hall.class);
  }

  @Autowired private EntityManager manager;

  @Override
  public List<HallResponse> findHalLByWorkerId(Long workerId) {
    String qry = "from Hall h where h.worker_id = :worker_Id";
    TypedQuery query = manager.createQuery(qry, Hall.class).setParameter("worker_Id", workerId);
    List<HallResponse> hallResponses = query.getResultList();
    return hallResponses;
  }
}
