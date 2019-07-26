package museum.service.impl;

import museum.dao.ExhibitDao;
import museum.dao.HallDao;
import museum.dto.hall.request.HallRequest;
import museum.dto.hall.response.HallResponse;
import museum.entity.Hall;
import museum.exception.BadIdException;
import museum.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HallServiceImpl implements HallService {

  @Autowired private HallDao hallDao;

  @Autowired private ExhibitDao exhibitDao;

//  @Autowired private WorkerService workerService;

  //  @Autowired private WorkerDao workerDao;

  @Transactional
  @Override
  public HallResponse save(HallRequest hallRequest) {
    Hall hall = new Hall();
    hall.setName(hallRequest.getName());
//    hall.setWorker(workerService.findById(hallRequest.getWorkerId()));
    return new HallResponse(hall);
  }

  @Transactional
  @Override
  public List<HallResponse> findAll() {
    return hallDao.findAll().stream().map(HallResponse::new).collect(Collectors.toList());
  }

  @Transactional
  @Override
  public Hall findById(Long id) throws BadIdException {
    if (hallDao == null) {
      throw new BadIdException("Hall with id " + id + " does not exists");
    }
    return hallDao.findById(id);
  }

  @Transactional
  @Override
  public HallResponse update(HallRequest hallRequest) {
    return  null;
  }

  @Transactional
  @Override
  public void deleteById(Long id) {
    Boolean isDeleted = hallDao.deleteById(id);
    if (!isDeleted) {
      throw new BadIdException("Hall has not row with id " + id);
    }
  }
}
