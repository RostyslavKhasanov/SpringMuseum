package museum.service;

import museum.dto.worker.WorkerDto;
import museum.dto.worker.WorkerStatDto;
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
}
