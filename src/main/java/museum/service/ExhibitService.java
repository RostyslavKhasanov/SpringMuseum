package museum.service;

import museum.dto.exhibit.ExhibitDto;
import museum.entity.Exhibit;

import java.util.List;

public interface ExhibitService {
  void save(ExhibitDto dto);

  List<ExhibitDto> findAll();

  Exhibit findById(Long id);

  Exhibit update(ExhibitDto dto);

  void deleteById(Long id);
}
