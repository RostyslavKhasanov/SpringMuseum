package museum.service.impl;

import lombok.AllArgsConstructor;
import museum.dao.ExhibitDao;
import museum.dto.exhibit.*;
import museum.entity.Exhibit;
import museum.exception.BadIdException;
import museum.service.AuthorService;
import museum.service.ExhibitService;
import museum.service.HallService;
import museum.utils.ObjectMapperUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service for Exhibit logic.
 *
 * @author Nazar Stasyuk
 * @version 1.0
 */
@Service
@AllArgsConstructor
public class ExhibitServiceImpl implements ExhibitService {

  private ExhibitDao dao;

  private AuthorService authorService;

  private HallService hallService;
  private ObjectMapperUtils mapper;

  /** Method that save new exhibit. */
  @Transactional
  @Override
  public void save(ExhibitSaveDto dto) {
    dao.save(mapper.map(dto, Exhibit.class));
  }

  /**
   * Method that return all exhibit dto.
   *
   * @return List of ExhibitIdInitialsDto.
   */
  @Transactional
  @Override
  public List<ExhibitIdInitialsDto> findAll() {
    return mapper.mapAll(dao.findAll(), ExhibitIdInitialsDto.class);
  }

  /**
   * Method that return exhibit dto by id.
   *
   * @return ExhibitFullDto - this is dto of exhibit.
   */
  @Transactional
  @Override
  public ExhibitFullDto findById(Long id) {
    Exhibit exhibit = dao.findById(id);
    if (exhibit == null) {
      throw new BadIdException("Exhibit has no any row with id " + id);
    }
    return mapper.map(exhibit, ExhibitFullDto.class);
  }

  /**
   * Method that return exhibit by id.
   *
   * @return Exhibit - this is entity.
   */
  @Transactional
  @Override
  public Exhibit getOneById(Long id) {
    Exhibit exhibit = dao.findById(id);
    if (exhibit == null) {
      throw new BadIdException("Exhibit has no any row with id " + id);
    }
    return exhibit;
  }

  /** Method that update exhibit. */
  @Transactional
  @Override
  public void update(ExhibitUpdateDto dto) {
    Exhibit newExhibit = dao.update(mapper.map(dto, Exhibit.class));
    if (newExhibit == null) {
      throw new BadIdException("Exhibit has no any row with id " + dto.getId());
    }
  }

  /** Method that delete exhibit by id. */
  @Transactional
  @Override
  public void deleteById(Long id) {
    Boolean isDeleted = dao.deleteById(id);
    if (!isDeleted) {
      throw new BadIdException("Exhibit has no any row with id " + id);
    }
  }

  /**
   * Method that for Exhibit material statistic.
   *
   * @return List of ExhibitMaterialStat
   */
  @Override
  public List<ExhibitMaterialStat> getMaterialStat() {
    return dao.getMaterialStat();
  }

  /**
   * Method that for Exhibit technology statistic.
   *
   * @return List of ExhibitTechnologyStat
   */
  @Override
  public List<ExhibitTechnologyStat> getTechnologyStat() {
    return dao.getTechnologyStat();
  }
}
