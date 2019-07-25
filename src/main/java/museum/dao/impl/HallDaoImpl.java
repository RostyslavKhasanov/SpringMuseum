package museum.dao.impl;

import museum.dao.ElementDaoImpl;
import museum.dao.HallDao;
import museum.entity.Hall;
import org.springframework.stereotype.Repository;

@Repository
public class HallDaoImpl extends ElementDaoImpl<Hall> implements HallDao {
  public HallDaoImpl() {
    super(Hall.class);
  }
}
