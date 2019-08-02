package museum.service.impl;

import lombok.AllArgsConstructor;
import museum.dao.ExcursionDao;
import museum.dto.excursion.ExcursionSaveDto;
import museum.dto.excursion.ExcursionUpdateDto;
import museum.dto.excursion.ExcursionResponse;
import museum.entity.Excursion;
import museum.exception.BadIdException;
import museum.exception.BadRequestForInputDate;
import museum.service.ExcursionService;
import museum.service.WorkerService;
import museum.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service for Excursion logic.
 *
 * @author Kateryna Horokh
 * @version 1.0
 */
@Service
//@AllArgsConstructor
public class ExcursionServiceImpl implements ExcursionService {

  @Autowired private ExcursionDao excursionDao;

  @Autowired private WorkerService workerService;

  private ObjectMapperUtils mapper;

  /** Method that save new excursion. */
  @Transactional
  @Override
  public void save(ExcursionSaveDto dtoRequest) {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    LocalDateTime begin = LocalDateTime.parse(dtoRequest.getBegin().replace("T", " "), formatter);

    LocalDateTime end = LocalDateTime.parse(dtoRequest.getEnd().replace("T", " "), formatter);

    Excursion excursion = new Excursion();
    excursion.setDescription(dtoRequest.getDescription());
    excursion.setBegin(begin);
    excursion.setEnd(end);
    excursion.setPrice(dtoRequest.getPrice());
    excursion.setWorker(workerService.getOneById(dtoRequest.getWorkerId()));
    excursionDao.save(excursion);
  }

  /** Method that update excursion. */
  @Transactional
  @Override
  public void update(ExcursionUpdateDto dtoRequest) {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    LocalDateTime begin = LocalDateTime.parse(dtoRequest.getBegin().replace("T", " "), formatter);

    LocalDateTime end = LocalDateTime.parse(dtoRequest.getEnd().replace("T", " "), formatter);

    Excursion excursion = new Excursion();
    excursion.setId(dtoRequest.getId());
    excursion.setDescription(dtoRequest.getDescription());
    excursion.setBegin(begin);
    excursion.setEnd(end);
    excursion.setPrice(dtoRequest.getPrice());
    excursion.setWorker(workerService.findById(dtoRequest.getWorkerId()));
    Excursion newExcursion = excursionDao.update(excursion);
    if (newExcursion == null) {
      throw new BadIdException("Excursion has no any row with id " + dtoRequest.getId());
    }
  }

  /**
   * Method that return all excursion dto.
   *
   * @return List of ExcursionResponse.
   */
  @Transactional
  @Override
  public List<ExcursionResponse> findAll() {
    return excursionDao.findAll().stream().map(ExcursionResponse::new).collect(Collectors.toList());
  }

  /**
   * Method that return excursion by id.
   *
   * @return Excursion - this is entity.
   */
  @Transactional
  @Override
  public ExcursionResponse findById(Long id) {
    Excursion excursion = excursionDao.findById(id);
    if (excursionDao == null) {
      throw new BadIdException("Excursion with id " + id + " does not exists");
    }
    return new ExcursionResponse(excursion);
  }

  /**
   * Method that return excursion by id.
   *
   * @return Excursion - entity.
   */
  @Transactional
  @Override
  public Excursion getOneById(Long id) {
    Excursion excursion = excursionDao.findById(id);
    if (excursion == null) {
      throw new BadIdException("Excursion has no any row with id " + id);
    }
    return excursion;
  }

  /** Method that delete excursion by id. */
  @Transactional
  @Override
  public void deleteById(Long id) {
    Boolean isDeleted = excursionDao.deleteById(id);
    if (!isDeleted) {
      throw new BadIdException("Excursion has not row with id " + id);
    }
  }

  /**
   * Method for searching excursions in time period based on given input.
   *
   * @param start start of time slot to search in
   * @param end end of time slot to search in
   * @return List of ExcursionResponse
   * @exception BadRequestForInputDate
   */
  @Transactional
  @Override
  public List<ExcursionResponse> findByPeriod(LocalDateTime start, LocalDateTime end)
      throws BadRequestForInputDate {
    if (start != null && end != null) {
      if (start.isBefore(end)) {
        return excursionDao.findByPeriod(start, end);
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
   * @param start start of time slot to search in
   * @param end end of time slot to search in
   * @return int count
   */
  @Transactional
  @Override
  public Integer findCountByPeriod(LocalDateTime start, LocalDateTime end) {
    int excursions = excursionDao.findCountByPeriod(start, end);
    return excursions;
  }
}
