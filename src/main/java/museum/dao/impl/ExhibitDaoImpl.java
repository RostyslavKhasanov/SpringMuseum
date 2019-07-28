package museum.dao.impl;

import museum.dao.ElementDaoImpl;
import museum.dao.ExhibitDao;
import museum.entity.Exhibit;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ExhibitDaoImpl extends ElementDaoImpl<Exhibit> implements ExhibitDao {
  public ExhibitDaoImpl() {
    super(Exhibit.class);
  }

//  @PersistenceContext
//  private EntityManager manager;
//
//  @Override
//  public List<ExhibitInfoDto> findExhibitsByHall(Long hallId) {
//    String string =
//        "from Exhibit e where e.hall = :hall_id";
//    Query query = manager.createQuery(string, Exhibit.class).setParameter("hall_id", hallId);
//    List<ExhibitInfoDto> exhibits = query.getResultList();
//    return exhibits;
//  }
}
