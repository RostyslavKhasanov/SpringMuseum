package museum.service.impl;

import museum.dao.ExhibitDao;
import museum.dao.HallDao;
import museum.dto.request.hall.HallSaveRequest;
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

  @Autowired private HallDao hallDao;

  @Autowired private ExhibitDao exhibitDao;

  @Transactional
  @Override
  public void save(HallSaveRequest hallRequest) {
    Hall hall = new Hall();
    hall.setName(hallRequest.getName());
    hallDao.save(hall);
  }

  @Transactional
  @Override
  public List<HallIdNameDtoResponse> findAll() {
    return hallDao.findAll().stream().map(HallIdNameDtoResponse::new).collect(Collectors.toList());
  }

//  @Transactional
//  @Override
//  public HallDtoResponse findById(Long id) throws BadIdException {
//    if (hallDao == null) {
//      throw new BadIdException("Hall with id " + id + " does not exists");
//    }
//    return hallDao.findById(id);
//  }

  @Transactional
  @Override
  public void deleteById(Long id) {
    Boolean isDeleted = hallDao.deleteById(id);
    if (!isDeleted) {
      throw new BadIdException("Hall has not row with id " + id);
    }
  }

  @Transactional
  @Override
  public List<HallDtoResponse> findByWorkerId(Long id) {
    return hallDao.findAll().stream().map(HallDtoResponse::new).collect(Collectors.toList());
  }
}
