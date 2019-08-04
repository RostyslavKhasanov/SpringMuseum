package museum.dao;

import museum.dto.excursion.ExcursionIdNameDto;
import museum.entity.Excursion;

import java.time.LocalDateTime;
import java.util.List;

/**
 * DAO interface for Excursion entity.
 *
 * @author Kateryna Horokh
 * @version 1.0
 */
public interface ExcursionDao extends ElementDao<Excursion> {

  /**
   * Gets excursions by given period.
   *
   * @param begin period begin.
   * @param end period end.
   * @return List of ExcursionIdNameDto.
   */
  List<ExcursionIdNameDto> findByPeriod(LocalDateTime begin, LocalDateTime end);

  /**
   * Gets count of excursions by given period.
   *
   * @param begin period begin.
   * @param end period end.
   * @return count of excursions.
   */
  Integer findCountByPeriod(LocalDateTime begin, LocalDateTime end);
}
