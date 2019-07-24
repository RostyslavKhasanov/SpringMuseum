package museum.dao;

import museum.entity.Exhibit;
import org.springframework.stereotype.Service;

@Service
public class ExhibitDao extends ElementDaoImpl<Exhibit> {
  public ExhibitDao() {
    super(Exhibit.class);
  }
}
