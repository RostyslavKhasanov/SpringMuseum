package museum.service.impl;

import museum.dao.ExhibitDao;
import museum.dto.exhibit.ExhibitDto;
import museum.entity.Exhibit;
import museum.exception.BadIdException;
import museum.service.AuthorService;
import museum.service.ExhibitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExhibitServiceImpl implements ExhibitService {

  @Autowired private ExhibitDao dao;

  @Autowired private AuthorService authorService;

  @Override
  public void save(ExhibitDto dto) {
    Exhibit exhibit = exhibitDtoToExhibit(dto);
    dao.save(exhibit);
  }

  @Transactional
  @Override
  public List<ExhibitDto> findAll() {
    List<Exhibit> exhibits = dao.findAll();
    return exhibits.stream().map(ExhibitDto::new).collect(Collectors.toList());
  }

  @Transactional
  @Override
  public Exhibit findById(Long id) {
    Exhibit exhibit = dao.findById(id);
    if (exhibit == null) {
      throw new BadIdException("Exhibits has not row with id " + id);
    }
    return exhibit;
  }

  @Transactional
  @Override
  public Exhibit update(ExhibitDto dto) {
    Exhibit exhibit = exhibitDtoToExhibit(dto);
    Exhibit update = dao.update(exhibit);
    if (update == null) {
      throw new BadIdException("Exhibits has not row with id " + dto.getId());
    }
    return update;
  }

  @Transactional
  @Override
  public void deleteById(Long id) {
    Boolean isDeleted = dao.deleteById(id);
    if (!isDeleted) {
      throw new BadIdException("Exhibits has not row with id " + id);
    }
  }

  private Exhibit exhibitDtoToExhibit(ExhibitDto dto) {
    Exhibit exhibit = new Exhibit();
    exhibit.setId(dto.getId());
    exhibit.setAuthor(authorService.findById(dto.getId()));
    // exhibit.setHall();
    exhibit.setMaterial(dto.getMaterial());
    exhibit.setTechnology(dto.getTechnology());
    exhibit.setName(dto.getName());
    return exhibit;
  }
}
