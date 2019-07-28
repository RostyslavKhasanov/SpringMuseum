package museum.service.impl;

import museum.dto.request.exhibit.ExhibitDto;
import museum.dto.request.exhibit.ExhibitNameDto;
import museum.dto.request.exhibit.ExhibitSaveDtoRequest;
import museum.dto.response.exhibit.ExhibitDtoResponse;
import museum.service.ExhibitService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExhibitServiceImpl implements ExhibitService {

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
