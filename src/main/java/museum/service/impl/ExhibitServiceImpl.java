package museum.service.impl;

import lombok.AllArgsConstructor;
import museum.dao.ExhibitDao;
import museum.dto.exhibit.*;
import museum.entity.Exhibit;
import museum.exception.BadIdException;
import museum.exception.EntityConstraintException;
import museum.service.AuthorService;
import museum.service.ExhibitService;
import museum.service.HallService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

  /** Method that save new exhibit. */
  @Transactional
  @Override
  public void save(ExhibitSaveDto dto) {
    dao.save(
        Exhibit.builder()
            .name(dto.getName())
            .material(dto.getMaterial())
            .technology(dto.getTechnology())
            .author(authorService.getOneById(dto.getAuthorId()))
            .hall(hallService.getOneById(dto.getHallId()))
            .build());
  }

  /**
   * Method that return all exhibit dto.
   *
   * @return List of ExhibitIdInitialsDto.
   */
  @Transactional
  @Override
  public List<ExhibitIdInitialsDto> findAll() {
    return dao.findAll().stream().map(ExhibitIdInitialsDto::new).collect(Collectors.toList());
  }

  /**
   * Method that return exhibit dto by id.
   *
   * @return ExhibitFullDto - this is dto of exhibit.
   */
  @Transactional
  @Override
  public ExhibitFullDto findById(Long id) throws BadIdException {
    Exhibit exhibit = dao.findById(id);
    if (exhibit == null) {
      throw new BadIdException("Exhibit has no any row with id " + id);
    }
    return new ExhibitFullDto(exhibit);
  }

  /**
   * Method that return exhibit by id.
   *
   * @return Exhibit - this is entity.
   */
  @Transactional
  @Override
  public Exhibit getOneById(Long id) throws BadIdException {
    Exhibit exhibit = dao.findById(id);
    if (exhibit == null) {
      throw new BadIdException("Exhibit has no any row with id " + id);
    }
    return exhibit;
  }

  /** Method that update exhibit. */
  @Transactional
  @Override
  public void update(ExhibitUpdateDto dto) throws BadIdException {
    Exhibit exhibit =
        Exhibit.builder()
            .id(dto.getId())
            .name(dto.getName())
            .material(dto.getMaterial())
            .technology(dto.getTechnology())
            .author(authorService.getOneById(dto.getAuthorId()))
            .hall(hallService.getOneById(dto.getHallId()))
            .build();
    Exhibit newExhibit = dao.update(exhibit);
    if (newExhibit == null) {
      throw new BadIdException("Exhibit has no any row with id " + dto.getId());
    }
  }

  /** Method that delete exhibit by id. */
  @Transactional
  @Override
  public void deleteById(Long id) throws BadIdException, EntityConstraintException {

    Boolean isDeleted = dao.deleteById(id);
    if (!isDeleted) {
      throw new BadIdException("Exhibit has no any row with id " + id);
    }
  }

  /**
   * Method that for Exhibit material statistic.
   *
   * @return List of ExhibitMaterialStatDto
   */
  @Override
  public List<ExhibitMaterialStatDto> getMaterialStat() {
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
