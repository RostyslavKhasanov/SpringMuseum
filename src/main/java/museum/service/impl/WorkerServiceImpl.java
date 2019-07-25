package museum.service.impl;

import museum.dao.WorkerDao;
import museum.dto.worker.WorkerDto;
import museum.entity.Worker;
import museum.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerServiceImpl implements WorkerService {

    @Autowired
    private WorkerDao workerDao;

    @Override
    public void save(WorkerDto workerDto) {

    }

//    private Worker workerDtoToWorker(WorkerDto workerDto) {
//        Worker worker = new Worker();
//        worker.setFirstName(workerDto.getFirstName());
//        worker.setSecondName(workerDto.getSecondName());
//        return worker;
//    }
}
