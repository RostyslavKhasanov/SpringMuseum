package museum.service;

import museum.dto.exhibit.ExhibitSaveDtoRequest;
import museum.dto.exhibit.ExhibitUpdateDtoRequest;
import museum.dto.exhibit.ExhibitDtoResponse;
import museum.dto.exhibit.ExhibitIdNameDtoResponse;
import museum.dto.exhibit.ExhibitMaterialStat;
import museum.dto.exhibit.ExhibitTechnologyStat;
import museum.entity.Exhibit;

import java.util.List;

public interface ExhibitService {
  void save(ExhibitSaveDtoRequest dto);

  List<ExhibitIdNameDtoResponse> findAll();

  ExhibitDtoResponse findById(Long id);

  Exhibit getOneById(Long id);

  void update(ExhibitUpdateDtoRequest dto);

  void deleteById(Long id);

  List<ExhibitMaterialStat> getMaterialStat();

  List<ExhibitTechnologyStat> getTechnologyStat();
}
