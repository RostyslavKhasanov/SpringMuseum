package museum.service.impl;

import museum.dao.WorkerDao;
import museum.dto.worker.WorkerDto;
import museum.dto.worker.WorkerStatDto;
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
  public void save(WorkerDto workerDto) {
    Worker worker = workerDtoToWorker(workerDto);
     workerDao.save(worker);
  }


  @Override
  public List<WorkerDto> findAll() {
    List<Worker> workers = workerDao.findAll();
    return workers.stream().map(WorkerDto::new).collect(Collectors.toList());
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
  public List<WorkerDto> findAllFreeGuide() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    LocalDateTime dateTime = LocalDateTime.now();
    List<WorkerDto> workers = workerDao.findAllFreeGuide(dateTime);
    return workers;
  }

  @Override
  public List<WorkerDto> findAllGuide() {
    List<Worker> workers = workerDao.findAllGuide();
    return workers.stream().map(WorkerDto::new).collect(Collectors.toList());
  }

  @Override
  public List<WorkerStatDto> findGuidesStat() {
    List<Worker> workers = workerDao.findAllGuide();
    List<WorkerStatDto> workerStatDtos = new ArrayList<>();
    for (Worker worker : workers) {
      workerStatDtos.add(workerToWorkerStatDto(worker));
    }
    return workerStatDtos;
  }

  @Override
  public void deleteById(Long id) {
    Boolean isDeleted = workerDao.deleteById(id);
    if (!isDeleted) {
      throw new BadIdException("Worker with entered id doesn't exist");
    }
  }

  private WorkerStatDto workerToWorkerStatDto(Worker worker) {
    WorkerStatDto workerStatDto = new WorkerStatDto();
    workerStatDto.setId(worker.getId());
    workerStatDto.setFirstName(worker.getFirstName());
    workerStatDto.setSecondName(worker.getSecondName());
    workerStatDto.setCountOfHour(workerDao.findCountOfHours(worker.getId()));
    workerStatDto.setCountOfExcursion(workerDao.findCountOfExcursion(worker.getId()));
    return workerStatDto;
  }

  private Worker workerDtoToWorker(WorkerDto workerDto) {
    Worker worker = new Worker();
    worker.setFirstName(workerDto.getFirstName());
    worker.setSecondName(workerDto.getSecondName());
    worker.setPost(postService.findById(workerDto.getPostId()));
    worker.setHalls(workerDto.getHalls());
    worker.setExcursions(workerDto.getExcursions());
    return worker;
  }
}
