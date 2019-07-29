package museum.service.impl;

import museum.dao.HallDao;
import museum.dto.request.hall.HallSaveRequest;
import museum.dto.request.hall.HallUpdateRequest;
import museum.dto.response.hall.HallDtoResponse;
import museum.dto.response.hall.HallIdNameDtoResponse;
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

  @Autowired private HallDao dao;
  // @Autowired private WorkerService workerService;

  @Transactional
  @Override
  public void save(HallSaveRequest dto) {
    Hall hall = new Hall();
    hall.setName(dto.getName());
    // hall.setWorker(workerService.);
    dao.save(hall);
  }

  @Transactional
  @Override
  public List<HallIdNameDtoResponse> findAll() {
    return dao.findAll().stream().map(HallIdNameDtoResponse::new).collect(Collectors.toList());
  }

  @Transactional
  @Override
  public HallDtoResponse findById(Long id) {
    Hall hall = dao.findById(id);
    if (hall == null) {
      throw new BadIdException("Hall has no row with id " + id);
    }
    return new HallDtoResponse(hall);
  }

  @Transactional
  @Override
  public Hall getOneById(Long id) {
    Hall hall = dao.findById(id);
    if (hall == null) {
      throw new BadIdException("Hall has no row with id " + id);
    }
    return hall;
  }

  @Transactional
  @Override
  public void update(HallUpdateRequest dto) {
    Hall hall = new Hall();
    hall.setId(dto.getId());
    hall.setName(dto.getName());
    // hall.setWorker(workerService.);
    Hall newHall = dao.update(hall);
    if (newHall == null) {
      throw new BadIdException("Hall has no row with id " + dto.getId());
    }
  }

  @Transactional
  @Override
  public void deleteById(Long id) {
    Boolean isDeleted = dao.deleteById(id);
    if (!isDeleted) {
      throw new BadIdException("Hall has no row with id " + id);
    }
  }
}
