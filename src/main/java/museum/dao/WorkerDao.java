package museum.dao;

import museum.dto.response.worker.WorkerDtoResponse;
import museum.entity.Worker;

import java.time.LocalDateTime;
import java.util.List;

public interface WorkerDao extends ElementDao<Worker> {

  Long findWorkerIdByName(String name);

  List<WorkerDtoResponse> findAllFreeGuide(LocalDateTime date);

  List<Worker> findAllGuide();

  Integer findCountOfExcursion(Long id);

  Integer findCountOfHours(Long id);
}
