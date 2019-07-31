package museum.service;

import museum.dto.exhibit.ExhibitSaveDto;
import museum.dto.exhibit.ExhibitUpdateDto;
import museum.dto.exhibit.ExhibitFullDto;
import museum.dto.exhibit.ExhibitIdInitialsDto;
import museum.dto.exhibit.ExhibitMaterialStat;
import museum.dto.exhibit.ExhibitTechnologyStat;
import museum.entity.Exhibit;

import java.util.List;

public interface ExhibitService {
  void save(ExhibitSaveDto dto);

  List<ExhibitIdInitialsDto> findAll();

  ExhibitFullDto findById(Long id);

  Exhibit getOneById(Long id);

  void update(ExhibitUpdateDto dto);

  void deleteById(Long id);

  List<ExhibitMaterialStat> getMaterialStat();

  List<ExhibitTechnologyStat> getTechnologyStat();
}
