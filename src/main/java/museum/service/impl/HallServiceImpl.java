package museum.service.impl;

import lombok.AllArgsConstructor;
import museum.dao.HallDao;
import museum.dto.hall.HallSaveRequest;
import museum.dto.hall.HallUpdateRequest;
import museum.dto.hall.HallDtoResponse;
import museum.dto.hall.HallIdNameDtoResponse;
import museum.entity.Hall;
import museum.exception.BadIdException;
import museum.exception.EntityConstraintException;
import museum.service.HallService;
import museum.service.WorkerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service for Hall logic.
 *
 * @author Kateryna Horokh
 * @version 1.0
 */
@Service
@AllArgsConstructor
public class HallServiceImpl implements HallService {

  private HallDao dao;

  private WorkerService workerService;

  /** Method that save new hall. */
  @Transactional
  @Override
  public void save(HallSaveRequest dto) {
    dao.save(Hall.builder()
            .name(dto.getName())
            .worker(workerService.getOneById(dto.getWorkerId())).build());
  }

  /**
   * Method that return all hall dto.
   *
   * @return List of HallIdNameDtoResponse.
   */
  @Transactional
  @Override
  public List<HallIdNameDtoResponse> findAll() {
      return dao.findAll().stream().map(HallIdNameDtoResponse::new).collect(Collectors.toList());
  }

  /**
   * Method that return hall by id.
   *
   * @return HallDtoResponse.
   * @exception BadIdException
   */
  @Transactional
  @Override
  public HallDtoResponse findById(Long id) {
    Hall hall = dao.findById(id);
    if (hall == null) {
      throw new BadIdException("Hall has no row with id " + id);
    }
    return new HallDtoResponse(hall);
  }

  /**
   * Method that return hall by id.
   *
   * @return Hall - entity.
   * @exception BadIdException
   */
  @Transactional
  @Override
  public Hall getOneById(Long id) {
    Hall hall = dao.findById(id);
    if (hall == null) {
      throw new BadIdException("Hall has no row with id " + id);
    }
    return hall;
  }

  /** Method that update hall.
   *
   * @exception BadIdException
   */
  @Transactional
  @Override
  public void update(HallUpdateRequest dto) {
      Hall hall = Hall.builder()
              .id(dto.getId())
              .name(dto.getName())
              .worker(workerService.getOneById(dto.getWorkerId()))
              .build();
      Hall newHall = dao.update(hall);
    if (newHall == null) {
      throw new BadIdException("Hall has no row with id " + dto.getId());
    }
  }

  /** Method that delete hall by id.
   *
   * @exception EntityConstraintException
   */
  @Transactional
  @Override
  public void deleteById(Long id) throws BadIdException{
    Hall hall = getOneById(id);
    if (hall.getExhibits().size() != 0) {
      throw new EntityConstraintException("You can not delete this hall because it is using.");
    }
    dao.deleteById(id);
  }

  /** Method that find hall by worker id. */
  @Transactional
  @Override
  public List<HallDtoResponse> findByWorkerId(Long id) {
    return dao.findHalLByWorkerId(id).stream()
        .map(HallDtoResponse::new)
        .collect(Collectors.toList());
  }
}
