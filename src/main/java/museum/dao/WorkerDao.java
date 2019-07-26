package museum.dao;

import museum.dto.worker.WorkerDto;
import museum.entity.Worker;

import java.time.LocalDateTime;
import java.util.List;

public interface WorkerDao extends ElementDao<Worker> {

    Long findWorkerIdByName(String name);

    List<WorkerDto> findAllFreeGuide(LocalDateTime date);

    List<WorkerDto> findAllGuide();

}
