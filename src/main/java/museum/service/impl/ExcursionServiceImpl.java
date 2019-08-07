package museum.service.impl;

import lombok.AllArgsConstructor;
import museum.dao.ExcursionDao;
import museum.dto.excursion.ExcursionFullDto;
import museum.dto.excursion.ExcursionIdNameDto;
import museum.dto.excursion.ExcursionSaveDto;
import museum.dto.excursion.ExcursionUpdateDto;
import museum.entity.Excursion;
import museum.exception.BadIdException;
import museum.exception.BadRequestForInputDate;
import museum.service.ExcursionService;
import museum.service.WorkerService;
import museum.utils.FormatStringToLocalDateTime;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service for Excursion logic.
 *
 * @author Kateryna Horokh
 * @version 1.0
 */
@Service
@AllArgsConstructor
public class ExcursionServiceImpl implements ExcursionService {

  private ExcursionDao excursionDao;

  private WorkerService workerService;

  private FormatStringToLocalDateTime dateTime;

  /** Method that save new excursion. */
  @Transactional
  @Override
  public void save(ExcursionSaveDto dtoRequest) {

    LocalDateTime begin = dateTime.convertToLocalDateTime(dtoRequest.getBegin());
    LocalDateTime end = dateTime.convertToLocalDateTime(dtoRequest.getEnd());

    excursionDao.save(
        Excursion.builder()
            .description(dtoRequest.getDescription())
            .begin(begin)
            .end(end)
            .price(dtoRequest.getPrice())
            .worker(workerService.getOneById(dtoRequest.getWorkerId()))
            .build());

    if(end.isBefore(begin)){
      throw new BadRequestForInputDate("Second given date has to be late than first.");
    } else if(begin.equals(end)) {
      throw new BadRequestForInputDate("Time of begin date and end date can not be same");
    }
  }

  /** Method that update excursion. */
  @Transactional
  @Override
  public void update(ExcursionUpdateDto dtoRequest) throws BadIdException, BadRequestForInputDate {

    LocalDateTime begin = dateTime.convertToLocalDateTime(dtoRequest.getBegin());
    LocalDateTime end = dateTime.convertToLocalDateTime(dtoRequest.getEnd());

    Excursion excursion =
        Excursion.builder()
            .id(dtoRequest.getId())
            .description(dtoRequest.getDescription())
            .begin(begin)
            .end(end)
            .price(dtoRequest.getPrice())
            .worker(workerService.getOneById(dtoRequest.getWorkerId()))
            .build();

    Excursion newExcursion = excursionDao.update(excursion);
    if (newExcursion == null) {
      throw new BadIdException("Excursion has no any row with id " + dtoRequest.getId());
    } else if(end.isBefore(begin)){
      throw new BadRequestForInputDate("Second given date has to be late than first.");
    } else if(begin.equals(end)) {
      throw new BadRequestForInputDate("Time of begin date and end date can not be same");
    }
  }

  /**
   * Method that return all excursion dto.
   *
   * @return List of ExcursionIdNameDto.
   */
  @Transactional
  @Override
  public List<ExcursionIdNameDto> findAll() {
    return excursionDao.findAll().stream()
        .map(ExcursionIdNameDto::new)
        .collect(Collectors.toList());
  }

  /**
   * Method that return excursion by id.
   *
   * @return ExcursionFullDto - this is dto.
   */
  @Transactional
  @Override
  public ExcursionFullDto findById(Long id) throws BadIdException {
    Excursion excursion = excursionDao.findById(id);
    if (excursion == null) {
      throw new BadIdException("Excursion has no row with id " + id);
    }
    return new ExcursionFullDto(excursion);
  }

  /**
   * Method that return excursion by id.
   *
   * @return Excursion - entity.
   * @exception BadIdException
   */
  @Transactional
  @Override
  public Excursion getOneById(Long id) throws BadIdException {
    Excursion excursion = excursionDao.findById(id);
    if (excursion == null) {
      throw new BadIdException("Excursion has no any row with id " + id);
    }
    return excursion;
  }

  /** Method that delete excursion by id.
   *
   * @exception BadIdException
   */
  @Transactional
  @Override
  public void deleteById(Long id) throws BadIdException {
    Boolean isDeleted = excursionDao.deleteById(id);
    if (!isDeleted) {
      throw new BadIdException("Excursion with id " + id + " does not exists");
    }
  }

  /**
   * Method for searching excursions in time period based on given input.
   *
   * @param begin start of time slot to search in
   * @param end end of time slot to search in
   * @return List of ExcursionFullDto
   * @exception BadRequestForInputDate
   */
  @Transactional
  @Override
  public List<ExcursionIdNameDto> findByPeriod(LocalDateTime begin, LocalDateTime end)
      throws BadRequestForInputDate {
    if (begin != null && end != null) {
      if (begin.isBefore(end)) {
        return excursionDao.findByPeriod(begin, end);
      } else {
        throw new BadRequestForInputDate("Second given date has to be late than first.");
      }
    } else {
      throw new BadRequestForInputDate("Date must have a value.");
    }
  }

  /**
   * Method for statistic excursions in time period based on given input.
   *
   * @param begin start of time slot to search in
   * @param end end of time slot to search in
   * @return int count of excursions.
   */
  @Transactional
  @Override
  public Integer findCountByPeriod(LocalDateTime begin, LocalDateTime end) {
    int excursions = excursionDao.findCountByPeriod(begin, end);
    return excursions;
  }
}
