package museum.service.impl;

import museum.dao.WorkerDao;
import museum.dto.worker.WorkerDto;
import museum.entity.Worker;
import museum.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkerServiceImpl implements WorkerService {

    @Autowired
    private WorkerDao workerDao;

    @Transactional
    @Override
    public void save(WorkerDto workerDto) {

    }

//    private Worker workerDtoToWorker(WorkerDto workerDto) {
//        Worker worker = new Worker();
//        worker.setFirstName(workerDto.getFirstName());
//        worker.setSecondName(workerDto.getSecondName());
//        return worker;
//    }

    @Transactional
    @Override
    public List<WorkerDto> findAll() {
        List<Worker> workers = workerDao.findAll();
        return workers.stream().map(WorkerDto::new).collect(Collectors.toList());
    }

    @Transactional
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
        List<WorkerDto> workers = workerDao.findAllGuide();
        return workers;
    }
}
