package museum.service;

import museum.dto.worker.WorkerDto;
import museum.entity.Worker;

import java.util.List;

public interface WorkerService {

    void save(WorkerDto workerDto);

    List<Worker> findAll();

    Worker findById(Long id);

}
