package museum.dao;

import museum.dto.exhibit.ExhibitMaterialStatDto;
import museum.dto.exhibit.ExhibitTechnologyStat;
import museum.entity.Exhibit;

import java.util.List;

/**
 * Data assess object interface for Exhibit logic
 *
 * @author Nazar Stasyuk
 * @version 1.0
 */
public interface ExhibitDao extends ElementDao<Exhibit> {
  /**
   * Method for Exhibit material statistic
   *
   * @return List of Exhibit material DTO
   */
  List<ExhibitMaterialStatDto> getMaterialStat();

  /**
   * Method for Exhibit technology statistic
   *
   * @return List of Exhibit technology DTO
   */
  List<ExhibitTechnologyStat> getTechnologyStat();
}
