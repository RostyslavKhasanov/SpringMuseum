package museum.service;

import museum.dto.request.worker.WorkerAddRequestDto;
import museum.dto.request.worker.WorkerUpdateRequestDto;
import museum.dto.response.worker.WorkerDtoResponse;
import museum.dto.response.worker.WorkerFirstSecondNameDtoResponse;
import museum.dto.response.worker.WorkerStatDtoResponse;
import museum.entity.Worker;

import java.util.List;

public interface WorkerService {

  void save(WorkerAddRequestDto workerAddRequestDto);

  List<WorkerFirstSecondNameDtoResponse> findAll();

  Worker findById(Long id);

  Long findWorkerIdByName(String name);

  List<WorkerDtoResponse> findAllFreeGuide();

  List<WorkerDtoResponse> findAllGuide();

  List<WorkerStatDtoResponse> findGuidesStat();

  void deleteById(Long id);

  Worker getOneById(Long id);

  void update(WorkerUpdateRequestDto workerUpdateRequestDto);
}
