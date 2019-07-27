package museum.service.impl;

import museum.dao.WorkerDao;
import museum.dto.worker.WorkerDto;
import museum.dto.worker.WorkerStatDto;
import museum.entity.Worker;
import museum.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
        List<Worker> workers = workerDao.findAllGuide();
        return workers.stream().map(WorkerDto::new).collect(Collectors.toList());
    }

    @Override
    public List<WorkerStatDto> findGuidesStat() {
        List<Worker> workers = workerDao.findAllGuide();
        List<WorkerStatDto> workerStatDtos = new ArrayList<>();
        for (Worker worker: workers) {
            workerStatDtos.add(workerDtoToWorkerStatDto(worker));
        }
        return workerStatDtos;
    }

    private WorkerStatDto workerDtoToWorkerStatDto(Worker worker) {
        WorkerStatDto workerStatDto = new WorkerStatDto();
        workerStatDto.setId(worker.getId());
        workerStatDto.setFirstName(worker.getFirstName());
        workerStatDto.setSecondName(worker.getSecondName());
        workerStatDto.setCountOfHour(workerDao.findCountOfHours(worker.getId()));
        workerStatDto.setCountOfExcursion(workerDao.findCountOfExcursion(worker.getId()));
        return workerStatDto;
    }
}
