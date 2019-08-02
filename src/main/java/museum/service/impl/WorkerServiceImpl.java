package museum.service.impl;

import lombok.AllArgsConstructor;
import museum.dao.WorkerDao;
import museum.dto.worker.*;
import museum.entity.Worker;
import museum.exception.BadIdException;
import museum.exception.BadNameException;
import museum.service.PostService;
import museum.service.WorkerService;
import museum.utils.ObjectMapperUtils;
import org.hibernate.jdbc.Work;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.security.acl.WorldGroupImpl;

import javax.persistence.NoResultException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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

  private ObjectMapperUtils modelMapper;

  private PostService postService;

  /**
   * Save worker.
   *
   * @param workerSaveDto request worker dto.
   */
  @Transactional
  @Override
  public void save(WorkerSaveDto workerSaveDto) {
    Worker worker = modelMapper.map(workerSaveDto, Worker.class);
    worker.setPost(postService.getOneById(workerSaveDto.getPostId()));
    workerDao.save(worker);
  }

  /**
   * Get all workers.
   *
   * @return List of workerFirstSecondNameDtoResponse;
   */
  @Transactional
  @Override
  public List<WorkerNamesDto> findAll() {
    List<Worker> workers = workerDao.findAll();
    return modelMapper.mapAll(workers, WorkerNamesDto.class);
  }

  /**
   * Get worker by id.
   *
   * @param id worker id.
   * @return worker;
   */
  @Transactional
  @Override
  public WorkerDto findById(Long id) {
    WorkerDto workerDto = modelMapper.map(workerDao.findById(id), WorkerDto.class);
    return workerDto;
  }

  /**
   * Get worker id by name.
   *
   * @param name worker name.
   * @throws BadIdException;
   * @return id of worker;
   */
  @Transactional
  @Override
  public Long findWorkerIdByName(String name) throws BadIdException {
    try {
      return workerDao.findWorkerIdByName(name);
    } catch (NoResultException e) {
      throw new BadNameException("Worker with name " + name + " doesn't exist");
    }
  }

  /**
   * Get all free guides.
   *
   * @return List of WorkerDtoResponse;
   */
  @Transactional
  @Override
  public List<WorkerNamesDto> findAllFreeGuide() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    LocalDateTime dateTime = LocalDateTime.now();
    return modelMapper.mapAll(workerDao.findAllFreeGuide(dateTime), WorkerNamesDto.class);
  }

  /**
   * Get all guides.
   *
   * @return List of WorkerDtoResponse;
   */
  @Transactional
  @Override
  public List<WorkerNamesDto> findAllGuide() {
    return modelMapper.mapAll(workerDao.findAllGuide(), WorkerNamesDto.class);
  }

  /**
   * Get guides statistic.
   *
   * @return List of WorkerStatDtoResponse;
   */
  @Transactional
  @Override
  public List<WorkerStatDto> findGuidesStat() {
    List<Worker> workers = workerDao.findAllGuide();
    List<WorkerStatDto> workerStatDto = new ArrayList<>();
    for (Worker worker : workers) {
      workerStatDto.add(mapperForStat(worker));
    }
    return workerStatDto;
  }

  /**
   * Delete worker by id.
   *
   * @param id worker id.
   */
  @Transactional
  @Override
  public void deleteById(Long id) {
    Boolean isDeleted = workerDao.deleteById(id);
    if (!isDeleted) {
      throw new BadIdException("Worker with entered id doesn't exist");
    }
  }

  /**
   * Get worker by id..
   *
   * @return Worker;
   */
  @Transactional
  @Override
  public Worker getOneById(Long id) {
    Worker worker = workerDao.findById(id);
    if (worker == null) {
      throw new BadIdException("Worker with id " + id + " doesn't exist");
    }
    return worker;
  }

  /**
   * Update worker info.
   *
   * @param workerEditDto request worker dto.
   */
  @Transactional
  @Override
  public void update(WorkerEditDto workerEditDto) {
    Worker worker = modelMapper.map(workerEditDto, Worker.class);
    worker.setPost(postService.getOneById(workerEditDto.getPostId()));
    workerDao.update(worker);
  }

  @Override
  public List<WorkerNamesDto> filterByName(String name) {
    return modelMapper.mapAll(workerDao.filterByName(name), WorkerNamesDto.class);
  }

  /**
   * Mapper from Worker to WorkerStatDto.
   *
   * @param worker worker object.
   * @return workerStatDto response dto.
   */
  private WorkerStatDto mapperForStat(Worker worker) {
    WorkerStatDto workerStatDtoResponse = new WorkerStatDto();
    workerStatDtoResponse.setId(worker.getId());
    workerStatDtoResponse.setFirstName(worker.getFirstName());
    workerStatDtoResponse.setSecondName(worker.getSecondName());
    workerStatDtoResponse.setCountOfHour(workerDao.findCountOfHours(worker.getId()));
    workerStatDtoResponse.setCountOfExcursion(workerDao.findCountOfExcursion(worker.getId()));
    return workerStatDtoResponse;
  }
}
