package museum.service;

import museum.dto.exhibit.ExhibitDto;
import museum.dto.exhibit.ExhibitInfoDto;
import museum.entity.Exhibit;

import java.util.List;

public interface ExhibitService {
  void save(ExhibitDto dto);

  List<ExhibitDto> findAll();

  Exhibit findById(Long id);

  Exhibit update(ExhibitDto dto);

  void deleteById(Long id);

  List<ExhibitInfoDto> findByHallId(Long id);
}
