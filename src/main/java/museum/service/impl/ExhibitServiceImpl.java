package museum.service.impl;

import museum.dao.ExhibitDao;
import museum.dto.request.exhibit.ExhibitSaveDtoRequest;
import museum.dto.request.exhibit.ExhibitUpdateDtoRequest;
import museum.dto.response.exhibit.ExhibitDtoResponse;
import museum.dto.response.exhibit.ExhibitIdNameDtoResponse;
import museum.dto.response.exhibit.ExhibitMaterialStat;
import museum.dto.response.exhibit.ExhibitTechnologyStat;
import museum.entity.Exhibit;
import museum.exception.BadIdException;
import museum.service.AuthorService;
import museum.service.ExhibitService;
import museum.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExhibitServiceImpl implements ExhibitService {

  @Autowired private ExhibitDao dao;

  @Autowired private AuthorService authorService;

  @Autowired private HallService hallService;

  @Transactional
  @Override
  public void save(ExhibitSaveDtoRequest dto) {
    Exhibit exhibit = new Exhibit();
    exhibit.setName(dto.getName());
    exhibit.setMaterial(dto.getMaterial());
    exhibit.setTechnology(dto.getTechnology());
    exhibit.setAuthor(authorService.getOneById(dto.getAuthorId()));
    exhibit.setHall(hallService.getOneById(dto.getHallId()));
    dao.save(exhibit);
  }

  @Transactional
  @Override
  public List<ExhibitIdNameDtoResponse> findAll() {
    return dao.findAll().stream().map(ExhibitIdNameDtoResponse::new).collect(Collectors.toList());
  }

  @Transactional
  @Override
  public ExhibitDtoResponse findById(Long id) {
    Exhibit exhibit = dao.findById(id);
    if (exhibit == null) {
      throw new BadIdException("Exhibit has no any row with id " + id);
    }
    return new ExhibitDtoResponse(exhibit);
  }

  @Transactional
  @Override
  public Exhibit getOneById(Long id) {
    Exhibit exhibit = dao.findById(id);
    if (exhibit == null) {
      throw new BadIdException("Exhibit has no any row with id " + id);
    }
    return exhibit;
  }

  @Transactional
  @Override
  public void update(ExhibitUpdateDtoRequest dto) {
    Exhibit exhibit = new Exhibit();
    exhibit.setId(dto.getId());
    exhibit.setName(dto.getName());
    exhibit.setMaterial(dto.getMaterial());
    exhibit.setTechnology(dto.getTechnology());
    exhibit.setAuthor(authorService.getOneById(dto.getAuthorId()));
    exhibit.setHall(hallService.getOneById(dto.getHallId()));
    Exhibit newExhibit = dao.update(exhibit);
    if (newExhibit == null) {
      throw new BadIdException("Exhibit has no any row with id " + dto.getId());
    }
  }

  @Transactional
  @Override
  public void deleteById(Long id) {
    Boolean isDeleted = dao.deleteById(id);
    if (!isDeleted) {
      throw new BadIdException("Exhibit has no any row with id " + id);
    }
  }

  @Override
  public List<ExhibitMaterialStat> getMaterialStat() {
    return dao.getMaterialStat();
  }

  @Override
  public List<ExhibitTechnologyStat> getTechnologyStat() {
    return dao.getTechnologyStat();
  }
}
