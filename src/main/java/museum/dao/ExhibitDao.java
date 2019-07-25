package museum.dao;

import museum.entity.Exhibit;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Repository
@Transactional
public class ExhibitDao extends ElementDaoImpl<Exhibit> {
  public ExhibitDao() {
    super(Exhibit.class);
  }
}
