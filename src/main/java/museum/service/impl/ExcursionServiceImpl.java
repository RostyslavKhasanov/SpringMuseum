package museum.service.impl;

import museum.dao.ExcursionDao;
import museum.dto.request.excursion.ExcursionRequestDto;
import museum.dto.request.excursion.ExcursionSaveDtoRequest;
import museum.dto.request.excursion.ExcursionUpdateDtoRequest;
import museum.dto.response.excursion.ExcursionResponse;
import museum.entity.Excursion;
import museum.exception.BadIdException;
import museum.service.ExcursionService;
import museum.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExcursionServiceImpl implements ExcursionService {

  @Autowired private ExcursionDao excursionDao;

  @Autowired private WorkerService workerService;

  @Transactional
  @Override
  public void save(ExcursionSaveDtoRequest dtoRequest) {
    Excursion excursion = new Excursion();
    excursion.setBegin(dtoRequest.getBegin());
    excursion.setEnd(dtoRequest.getEnd());
    excursion.setPrice(dtoRequest.getPrice());
    excursion.setWorker(workerService.getOneById(dtoRequest.getWorkerId()));
    excursionDao.save(excursion);
  }

  @Transactional
  @Override
  public List<ExcursionResponse> findAll() {
    return excursionDao.findAll().stream().map(ExcursionResponse::new).collect(Collectors.toList());
  }

  @Transactional
  @Override
  public Excursion findById(Long id) {
    if (excursionDao == null) {
      throw new BadIdException("Excursion with id " + id + " does not exists");
    }
    return excursionDao.findById(id);
  }

  @Transactional
  @Override
  public void update(ExcursionUpdateDtoRequest dtoRequest) {
    Excursion excursion = new Excursion();
    excursion.setId(dtoRequest.getId());
    excursion.setBegin(dtoRequest.getBegin());
    excursion.setEnd(dtoRequest.getEnd());
    excursion.setPrice(dtoRequest.getPrice());
    excursion.setWorker(workerService.getOneById(dtoRequest.getWorkerId()));
    Excursion newExcursion = excursionDao.update(excursion);
    if (newExcursion == null) {
      throw new BadIdException("Excursion has no any row with id " + dtoRequest.getId());
    }
  }

  @Transactional
  @Override
  public void deleteById(Long id) {
    Boolean isDeleted = excursionDao.deleteById(id);
    if (!isDeleted) {
      throw new BadIdException("Hall has not row with id " + id);
    }
  }

  @Transactional
  @Override
  public List<ExcursionResponse> findByPeriod(LocalDateTime start, LocalDateTime end) {
    return excursionDao.findByPeriod(start, end);
  }

  @Transactional
  @Override
  public int findCountByPeriod(LocalDateTime start, LocalDateTime end) {
    int excursions =
        excursionDao.findCountByPeriod(start, end);
    return excursions;
  }
}
