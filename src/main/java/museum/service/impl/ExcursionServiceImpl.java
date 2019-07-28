package museum.service.impl;

import museum.dao.ExcursionDao;
import museum.dto.request.excursion.ExcursionRequest;
import museum.dto.response.excursion.ExcursionResponse;
import museum.entity.Excursion;
import museum.exception.BadIdException;
import museum.service.ExcursionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExcursionServiceImpl implements ExcursionService {

    @Autowired private ExcursionDao excursionDao;

    @Transactional
    @Override
    public ExcursionResponse save(ExcursionRequest excursionRequest) {
        Excursion excursion = new Excursion();
        excursion.setBegin(excursionRequest.getBegin());
        excursion.setEnd(excursionRequest.getEnd());
        excursion.setPrice(excursionRequest.getPrice());
//        excursion.setWorker(workerService.findById(excursionRequest.getWorkerId()));
        return new ExcursionResponse(excursion);
    }

    @Transactional
    @Override
    public List<ExcursionResponse> findAll() {
        return excursionDao.findAll().stream().map(ExcursionResponse::new).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public Excursion findById(Long id) {
        if (excursionDao == null) {
            throw new BadIdException("Excursion with id " + id + " does not exists");
        }
        return excursionDao.findById(id);
    }

    @Transactional
    @Override
    public ExcursionResponse update(ExcursionRequest excursionRequest) {
        return  null;
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        Boolean isDeleted = excursionDao.deleteById(id);
        if (!isDeleted) {
            throw new BadIdException("Hall has not row with id " + id);
        }
    }

    @Transactional
    @Override
    public List<ExcursionResponse> findByPeriod(LocalDateTime start, LocalDateTime end) {
        return excursionDao.findByPeriod(start, end);
    }
}
