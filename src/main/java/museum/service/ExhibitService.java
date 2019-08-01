package museum.service;

import museum.dto.exhibit.ExhibitSaveDto;
import museum.dto.exhibit.ExhibitUpdateDto;
import museum.dto.exhibit.ExhibitFullDto;
import museum.dto.exhibit.ExhibitIdInitialsDto;
import museum.dto.exhibit.ExhibitMaterialStat;
import museum.dto.exhibit.ExhibitTechnologyStat;
import museum.entity.Exhibit;
import museum.exception.BadIdException;

import java.util.List;

public interface ExhibitService {
  void save(ExhibitSaveDto dto);

  List<ExhibitIdInitialsDto> findAll();

  ExhibitFullDto findById(Long id) throws BadIdException;

  Exhibit getOneById(Long id) throws BadIdException;

  void update(ExhibitUpdateDto dto) throws BadIdException;

  void deleteById(Long id) throws BadIdException;

  List<ExhibitMaterialStat> getMaterialStat();

  List<ExhibitTechnologyStat> getTechnologyStat();
}
