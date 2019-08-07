package museum.service.impl;

import lombok.AllArgsConstructor;
import museum.dao.WorkerDao;
import museum.dto.worker.*;
import museum.entity.Worker;
import museum.exception.BadIdException;
import museum.exception.BadNameException;
import museum.exception.EntityConstraintException;
import museum.exception.WorkerStatException;
import museum.service.PostService;
import museum.service.WorkerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service implementation for Worker entity.
 *
 * @author Rostyslav Khasanov
 * @version 1.0
 */
@Service
@AllArgsConstructor
public class WorkerServiceImpl implements WorkerService {

  private WorkerDao workerDao;

  private PostService postService;

  /**
   * Save worker.
   *
   * @param workerSaveDto request worker dto.
   */
  @Transactional
  @Override
  public void save(WorkerSaveDto workerSaveDto) {
    workerDao.save(
        Worker.builder()
            .firstName(workerSaveDto.getFirstName())
            .secondName(workerSaveDto.getSecondName())
            .post(postService.getOneById(workerSaveDto.getPostId()))
            .build());
  }

  /**
   * Get all workers.
   *
   * @return List of WorkerNamesDto;
   */
  @Transactional
  @Override
  public List<WorkerNamesDto> findAll() {
    List<Worker> workers = workerDao.findAll();
    return workers.stream().map(WorkerNamesDto::new).collect(Collectors.toList());
  }

  /**
   * Get worker by id.
   *
   * @param id worker id.
   * @throws BadIdException if worker with entered id doesn't exist.
   * @return worker;
   */
  @Transactional
  @Override
  public WorkerDto findById(Long id) throws BadIdException {
    Worker worker = workerDao.findById(id);
    if (worker == null) {
      throw new BadIdException("Worker with entered id doesn't exist!");
    } else {
      return new WorkerDto(worker);
    }
  }

  /**
   * Get worker id by name.
   *
   * @param name worker name.
   * @throws BadNameException if worker with entered name doesn't exist.
   * @return id of worker.
   */
  @Transactional
  @Override
  public Long findWorkerIdByName(String name) throws BadNameException {
    try {
      return workerDao.findWorkerIdByName(name);
    } catch (NoResultException e) {
      throw new BadNameException("Worker with name " + name + " doesn't exist");
    }
  }

  /**
   * Get all free guides.
   *
   * @return List of WorkerDtoResponse.
   * @return List of WorkerDtoResponse.
   */
  @Transactional
  @Override
  public List<WorkerNamesDto> findAllFreeGuide() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    LocalDateTime dateTime = LocalDateTime.now();
    List<Worker> workers = workerDao.findAllFreeGuide(dateTime);
    return workers.stream().map(WorkerNamesDto::new).collect(Collectors.toList());
  }

  /**
   * Get all guides.
   *
   * @return List of WorkerNamesDto.
   */
  @Transactional
  @Override
  public List<WorkerNamesDto> findAllGuide() {
    List<Worker> workers = workerDao.findAllGuide();
    return workers.stream().map(WorkerNamesDto::new).collect(Collectors.toList());
  }

  /**
   * Get guides statistic.
   *
   * @throws WorkerStatException if excursions doesn't exist.
   * @return List of WorkerStatDto.
   */
  @Transactional
  @Override
  public List<WorkerStatDto> findGuidesStat() throws WorkerStatException {
    try {
      List<Worker> workers = workerDao.findAllGuide();
      List<WorkerStatDto> workerStatDto = new ArrayList<>();
      for (Worker worker : workers) {
        workerStatDto.add(mapperToWorkerStatDto(worker));
      }
      return workerStatDto;
    } catch (NoResultException e) {
      throw new WorkerStatException("Excursions or halls doesn't exist");
    }
  }

  /**
   * Delete worker by id.
   *
   * @throws EntityConstraintException if worker has some responsibility (serve halls or has
   *     excursion).
   * @param id worker id.
   */
  @Transactional
  @Override
  public void deleteById(Long id) throws EntityConstraintException {
    Worker worker = getOneById(id);
    if ((worker.getHalls().size() != 0) || (worker.getExcursions().size() != 0)) {
      throw new EntityConstraintException(
          "You can not delete this worker because he has some responsibility!");
    } else {
      workerDao.deleteById(id);
    }
  }

  /**
   * Get worker by id.
   *
   * @throws BadIdException if worker with entered id doesn't exist.
   * @return Worker.
   */
  @Transactional
  @Override
  public Worker getOneById(Long id) throws BadIdException {
    Worker worker = workerDao.findById(id);
    if (worker == null) {
      throw new BadIdException("Worker with id " + id + " doesn't exist");
    } else {
      return worker;
    }
  }

  /**
   * Update worker info.
   *
   * @param workerEditDto request worker dto.
   */
  @Transactional
  @Override
  public void update(WorkerEditDto workerEditDto) {
    workerDao.update(
        Worker.builder()
            .id(workerEditDto.getId())
            .firstName(workerEditDto.getFirstName())
            .secondName(workerEditDto.getSecondName())
            .post(postService.getOneById(workerEditDto.getPostId()))
            .build());
  }

  /**
   * Mapper from Worker to WorkerStatDto.
   *
   * @param worker worker object.
   * @return workerStatDto response dto.
   */
  private WorkerStatDto mapperToWorkerStatDto(Worker worker) {
    WorkerStatDto workerStat = new WorkerStatDto();
    workerStat.setFirstName(worker.getFirstName());
    workerStat.setSecondName(worker.getSecondName());
    workerStat.setCountOfHour(workerDao.findCountOfHours(worker.getId()));
    workerStat.setCountOfExcursion(workerDao.findCountOfExcursion(worker.getId()));
    return workerStat;
  }
}
