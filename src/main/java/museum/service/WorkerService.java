package museum.service;

import museum.dto.response.worker.WorkerDto;
import museum.dto.response.worker.WorkerStatDto;
import museum.entity.Worker;

import java.util.List;

public interface WorkerService {

  void save(WorkerDto workerDto);

  List<WorkerDto> findAll();

  Worker findById(Long id);

  Long findWorkerIdByName(String name);

  List<WorkerDto> findAllFreeGuide();

  List<WorkerDto> findAllGuide();

  List<WorkerStatDto> findGuidesStat();

  void deleteById(Long id);
}
