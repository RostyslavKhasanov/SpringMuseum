package museum.dao.impl;

import museum.dao.ElementDaoImpl;
import museum.dao.ExhibitDao;
import museum.dto.exhibit.ExhibitMaterialStat;
import museum.dto.exhibit.ExhibitTechnologyStat;
import museum.entity.Exhibit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Repository for Exhibit logic.
 *
 * @author Nazar Stasyuk
 * @version 1.0
 */
@Repository
public class ExhibitDaoImpl extends ElementDaoImpl<Exhibit> implements ExhibitDao {
  @Autowired private EntityManager manager;

  public ExhibitDaoImpl() {
    super(Exhibit.class);
  }

  /**
   * Method for Exhibit material statistic.
   *
   * @return List of ExhibitMaterialStat
   */
  @Override
  public List<ExhibitMaterialStat> getMaterialStat() {

    List<Object[]> resultList =
        manager
            .createQuery(
                "select e.material, count(e.material) from Exhibit e group by e.material",
                Object[].class)
            .getResultList();

    List<ExhibitMaterialStat> exhibitTechnologyStats = new ArrayList<>();
    for (Object[] a : resultList) {
      exhibitTechnologyStats.add(new ExhibitMaterialStat(a[0].toString(), (Long) a[1]));
    }
    return exhibitTechnologyStats;
  }

  /**
   * Method for Exhibit technology statistic.
   *
   * @return List of ExhibitMaterialStat
   */
  @Override
  public List<ExhibitTechnologyStat> getTechnologyStat() {

    List<Object[]> resultList =
        manager
            .createQuery(
                "select e.technology, count(e.technology) from Exhibit e group by e.technology",
                Object[].class)
            .getResultList();

    List<ExhibitTechnologyStat> exhibitTechnologyStats = new ArrayList<>();
    for (Object[] a : resultList) {
      exhibitTechnologyStats.add(new ExhibitTechnologyStat(a[0].toString(), (Long) a[1]));
    }
    return exhibitTechnologyStats;
  }
}
