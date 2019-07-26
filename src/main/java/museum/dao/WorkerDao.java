package museum.dao;

import museum.dto.worker.WorkerDto;
import museum.entity.Worker;

public interface WorkerDao extends ElementDao<Worker> {

    Long findWorkerIdByName(String name);

}
