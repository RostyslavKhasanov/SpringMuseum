package museum.service;

import museum.dto.excursion.ExcursionFullDto;
import museum.dto.excursion.ExcursionIdNameDto;
import museum.dto.excursion.ExcursionSaveDto;
import museum.dto.excursion.ExcursionUpdateDto;
import museum.entity.Excursion;
import museum.exception.BadIdException;
import museum.exception.BadRequestForInputDate;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Service interface for Excursion entity.
 *
 * @author Kateryna Horokh
 * @version 1.0
 */
public interface ExcursionService {

  /**
   * Save excursion.
   *
   * @param excursionSaveDto request excursion dto.
   */
  void save(ExcursionSaveDto excursionSaveDto) throws BadRequestForInputDate;

  /**
   * Get all excursions.
   *
   * @return List of ExcursionIdNameDto.
   */
  List<ExcursionIdNameDto> findAll();

  /**
   * Get excursion - dto by id.
   *
   * @param id excursion id.
   * @return excursion.
   * @exception BadIdException
   */
  ExcursionFullDto findById(Long id) throws BadIdException;

  /**
   * Get excursion - entity by id.
   *
   * @param id excursion id.
   * @return excursion.
   * @exception BadIdException
   */
  Excursion getOneById(Long id) throws BadIdException;

  /**
   * Update excursion info.
   *
   * @param excursionUpdateDto request excursion dto.
   * @exception BadIdException
   */
  void update(ExcursionUpdateDto excursionUpdateDto) throws BadIdException, BadRequestForInputDate;

  /**
   * Delete excursion by id.
   *
   * @param id excursion id.
   * @exception BadIdException
   */
  void deleteById(Long id) throws BadIdException;

  /**
   * Get excursions by time period.
   *
   * @param begin start of period.
   * @param end end of period.
   * @exception BadRequestForInputDate
   */
  List<ExcursionIdNameDto> findByPeriod(LocalDateTime begin, LocalDateTime end)
      throws BadRequestForInputDate;

  /**
   * Get statistic of excursion's count by time period.
   *
   * @param start start of period.
   * @param end end of period.
   * @return int - count og excursions.
   */
  Integer findCountByPeriod(LocalDateTime start, LocalDateTime end);
}
