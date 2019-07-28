package museum.service.impl;

import museum.dao.ExhibitDao;
import museum.dto.request.exhibit.ExhibitDto;
import museum.dto.request.exhibit.ExhibitNameDto;
import museum.dto.request.exhibit.ExhibitSaveDtoRequest;
import museum.dto.response.exhibit.ExhibitDtoResponse;
import museum.entity.Exhibit;
import museum.service.AuthorService;
import museum.service.ExhibitService;
import museum.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExhibitServiceImpl implements ExhibitService {

  @Autowired private ExhibitDao dao;

  @Autowired private AuthorService authorService;

  @Autowired private HallService hallService;

  @Override
  public void save(ExhibitSaveDtoRequest dto) {
   /* Exhibit exhibit = new Exhibit();
    exhibit.setName(dto.getName());
    exhibit.setMaterial(dto.getMaterial());
    exhibit.setTechnology(dto.getTechnology());
    exhibit.setAuthor(authorService.getOneById(dto.getAuthorId()));
    exhibit.setHall(hallService.);
    dao.save();*/
  }

  @Override
  public List<ExhibitNameDto> findAll() {
    return null;
  }

  @Override
  public ExhibitDtoResponse findById(Long id) {
    return null;
  }

  @Override
  public void update(ExhibitDto dto) {}

  @Override
  public void deleteById(Long id) {}
}
