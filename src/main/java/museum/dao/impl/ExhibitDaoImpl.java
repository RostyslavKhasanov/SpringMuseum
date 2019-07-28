package museum.dao.impl;

import museum.dao.ElementDaoImpl;
import museum.dao.ExhibitDao;
import museum.entity.Exhibit;
import org.springframework.stereotype.Repository;

@Repository
public class ExhibitDaoImpl extends ElementDaoImpl<Exhibit> implements ExhibitDao {
  public ExhibitDaoImpl() {
    super(Exhibit.class);
  }
}
