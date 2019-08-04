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

  List<ExcursionIdNameDto> findByPeriod(LocalDateTime begin, LocalDateTime end);

  Integer findCountByPeriod(LocalDateTime begin, LocalDateTime end);
}
