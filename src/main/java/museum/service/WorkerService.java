package museum.service;

import museum.dto.request.worker.WorkerAddRequestDto;
import museum.dto.response.worker.WorkerDto;
import museum.dto.response.worker.WorkerResponse;
import museum.dto.response.worker.WorkerStatDto;
import museum.entity.Worker;

import java.util.List;

public interface WorkerService {

  void save(WorkerAddRequestDto workerAddRequestDto);

  List<WorkerResponse> findAll();

  Worker findById(Long id);

  Long findWorkerIdByName(String name);

  List<WorkerDto> findAllFreeGuide();

  List<WorkerDto> findAllGuide();

  List<WorkerStatDto> findGuidesStat();

  void deleteById(Long id);

  Worker getOneById(Long id);
}
