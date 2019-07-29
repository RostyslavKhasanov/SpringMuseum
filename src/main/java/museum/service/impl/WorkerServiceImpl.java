package museum.service.impl;

import museum.dao.WorkerDao;
import museum.dto.request.worker.WorkerAddRequestDto;
import museum.dto.response.worker.WorkerDtoResponse;
import museum.dto.response.worker.WorkerIdFirstSecondNameDtoResponse;
import museum.dto.response.worker.WorkerStatDtoResponse;
import museum.entity.Worker;
import museum.exception.BadIdException;
import museum.service.PostService;
import museum.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    Worker worker = workerAddRequestDtoToWorker(workerAddRequestDto);
    workerDao.save(worker);
  }

  @Override
  public List<WorkerIdFirstSecondNameDtoResponse> findAll() {
    List<Worker> workers = workerDao.findAll();
    return workers.stream().map(WorkerIdFirstSecondNameDtoResponse::new).collect(Collectors.toList());
  }

  @Override
  public Worker findById(Long id) {
    Worker worker = workerDao.findById(id);
    return worker;
  }

  @Override
  public Long findWorkerIdByName(String name) {
    return workerDao.findWorkerIdByName(name);
  }

  @Override
  public List<WorkerDtoResponse> findAllFreeGuide() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    LocalDateTime dateTime = LocalDateTime.now();
    List<WorkerDtoResponse> workers = workerDao.findAllFreeGuide(dateTime);
    return workers;
  }

  @Override
  public List<WorkerDtoResponse> findAllGuide() {
    List<Worker> workers = workerDao.findAllGuide();
    return workers.stream().map(WorkerDtoResponse::new).collect(Collectors.toList());
  }

  @Override
  public List<WorkerStatDtoResponse> findGuidesStat() {
    List<Worker> workers = workerDao.findAllGuide();
    List<WorkerStatDtoResponse> workerStatDtos = new ArrayList<>();
    for (Worker worker : workers) {
      workerStatDtos.add(workerToWorkerStatDto(worker));
    }
    return workerStatDtos;
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
    Worker worker = new Worker();
    if (worker == null) {
      throw new BadIdException("Author has no row with id " + id);
    }
    return worker;
  }

  private WorkerStatDtoResponse workerToWorkerStatDto(Worker worker) {
    WorkerStatDtoResponse workerStatDto = new WorkerStatDtoResponse();
    workerStatDto.setId(worker.getId());
    workerStatDto.setFirstName(worker.getFirstName());
    workerStatDto.setSecondName(worker.getSecondName());
    workerStatDto.setCountOfHour(workerDao.findCountOfHours(worker.getId()));
    workerStatDto.setCountOfExcursion(workerDao.findCountOfExcursion(worker.getId()));
    return workerStatDto;
  }

  private Worker workerAddRequestDtoToWorker(WorkerAddRequestDto workerAddRequestDto) {
    Worker worker = new Worker();
    worker.setFirstName(workerAddRequestDto.getFirstName());
    worker.setSecondName(workerAddRequestDto.getSecondName());
    worker.setPost(postService.getOneById(workerAddRequestDto.getPostId()));
    return worker;
  }
}
