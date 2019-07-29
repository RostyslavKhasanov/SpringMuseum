package museum.service.impl;

import museum.dao.WorkerDao;
import museum.dto.request.worker.WorkerAddRequestDto;
import museum.dto.response.worker.WorkerDtoResponse;
import museum.dto.response.worker.WorkerFirstSecondNameDtoResponse;
import museum.dto.response.worker.WorkerStatDtoResponse;
import museum.entity.Worker;
import museum.exception.BadIdException;
import museum.exception.BadNameException;
import museum.service.PostService;
import museum.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkerServiceImpl implements WorkerService {

  @Autowired private WorkerDao workerDao;

  @Autowired private PostService postService;

  @Transactional
  @Override
  public void save(WorkerAddRequestDto workerAddRequestDto) {
    workerDao.save(workerAddRequestDtoToWorker(workerAddRequestDto));
  }

  @Transactional
  @Override
  public List<WorkerFirstSecondNameDtoResponse> findAll() {
    List<Worker> workers = workerDao.findAll();
    return workers.stream().map(WorkerFirstSecondNameDtoResponse::new).collect(Collectors.toList());
  }

  @Transactional
  @Override
  public Worker findById(Long id) {
    Worker worker = workerDao.findById(id);
    return worker;
  }

  @Transactional
  @Override
  public Long findWorkerIdByName(String name) {
      try {
          return workerDao.findWorkerIdByName(name);
      } catch (NoResultException e) {
          throw new BadNameException("Worker with name " + name + " doesn't exist");
      }
  }

  @Transactional
  @Override
  public List<WorkerDtoResponse> findAllFreeGuide() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    LocalDateTime dateTime = LocalDateTime.now();
    List<WorkerDtoResponse> workers = workerDao.findAllFreeGuide(dateTime);
    return workers;
  }

  @Transactional
  @Override
  public List<WorkerDtoResponse> findAllGuide() {
    List<Worker> workers = workerDao.findAllGuide();
    return workers.stream().map(WorkerDtoResponse::new).collect(Collectors.toList());
  }

  @Transactional
  @Override
  public List<WorkerStatDtoResponse> findGuidesStat() {
    List<Worker> workers = workerDao.findAllGuide();
    List<WorkerStatDtoResponse> workerStatDtoResponses = new ArrayList<>();
    for (Worker worker : workers) {
      workerStatDtoResponses.add(workerToWorkerStatDto(worker));
    }
    return workerStatDtoResponses;
  }

  @Transactional
  @Override
  public void deleteById(Long id) {
    Boolean isDeleted = workerDao.deleteById(id);
    if (!isDeleted) {
      throw new BadIdException("Worker with entered id doesn't exist");
    }
  }

  @Override
  public Worker getOneById(Long id) {
    Worker worker = workerDao.findById(id);
    if (worker == null) {
      throw new BadIdException("Worker with id " + id + " doesn't exist");
    }
    return worker;
  }

  private WorkerStatDtoResponse workerToWorkerStatDto(Worker worker) {
    WorkerStatDtoResponse workerStatDtoResponse = new WorkerStatDtoResponse();
    workerStatDtoResponse.setId(worker.getId());
    workerStatDtoResponse.setFirstName(worker.getFirstName());
    workerStatDtoResponse.setSecondName(worker.getSecondName());
    workerStatDtoResponse.setCountOfHour(workerDao.findCountOfHours(worker.getId()));
    workerStatDtoResponse.setCountOfExcursion(workerDao.findCountOfExcursion(worker.getId()));
    return workerStatDtoResponse;
  }

  private Worker workerAddRequestDtoToWorker(WorkerAddRequestDto workerAddRequestDto) {
    Worker worker = new Worker();
    worker.setFirstName(workerAddRequestDto.getFirstName());
    worker.setSecondName(workerAddRequestDto.getSecondName());
    worker.setPost(postService.getOneById(workerAddRequestDto.getPostId()));
    return worker;
  }
}
