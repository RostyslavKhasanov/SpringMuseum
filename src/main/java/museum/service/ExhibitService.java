package museum.service;

import museum.dto.request.exhibit.ExhibitDto;
import museum.dto.request.exhibit.ExhibitNameDto;
import museum.dto.request.exhibit.ExhibitSaveDtoRequest;
import museum.dto.response.exhibit.ExhibitDtoResponse;
import museum.entity.Exhibit;

import java.util.List;

public interface ExhibitService {
  void save(ExhibitSaveDtoRequest dto);

  List<ExhibitNameDto> findAll();

  ExhibitDtoResponse findById(Long id);

  void update(ExhibitDto dto);

  void deleteById(Long id);
}
