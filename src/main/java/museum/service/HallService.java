package museum.service;

import museum.dto.hall.HallSaveRequest;
import museum.dto.hall.HallUpdateRequest;
import museum.dto.hall.HallDtoResponse;
import museum.dto.hall.HallIdNameDtoResponse;
import museum.entity.Hall;
import museum.exception.BadIdException;
import museum.exception.EntityConstraintException;

import java.util.List;

/**
 * Service interface for Hall entity.
 *
 * @author Kateryna Horokh
 * @version 1.0
 */
public interface HallService {

  /**
   * Save hall.
   *
   * @param dto request hall dto.
   */
  void save(HallSaveRequest dto);

  /**
   * Get all hall.
   *
   * @return List of ExcursionIdNameDto.
   */
  List<HallIdNameDtoResponse> findAll();

  /**
   * Get hall - dto by id.
   *
   * @param id hall id.
   * @return hall.
   * @exception BadIdException
   */
  HallDtoResponse findById(Long id) throws BadIdException;

  /**
   * Get hall - entity by id.
   *
   * @param id hall id.
   * @return hall.
   * @exception BadIdException
   */
  Hall getOneById(Long id) throws BadIdException;

  /**
   * Update hall info.
   *
   * @param dto request excursion dto.
   * @exception BadIdException
   */
  void update(HallUpdateRequest dto) throws BadIdException;

  /**
   * Delete hall by id.
   *
   * @param id hall id.
   * @exception BadIdException
   */
  void deleteById(Long id) throws BadIdException;

  /**
   * Find hall by worker id.
   *
   * @param id hall id.
   */
  List<HallDtoResponse> findByWorkerId(Long id);
}
