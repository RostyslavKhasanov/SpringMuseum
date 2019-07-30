package museum.service;

import museum.dto.excursion.ExcursionSaveDtoRequest;
import museum.dto.excursion.ExcursionUpdateDtoRequest;
import museum.dto.excursion.ExcursionResponse;
import museum.entity.Excursion;

import java.time.LocalDateTime;
import java.util.List;

public interface ExcursionService {

  void save(ExcursionSaveDtoRequest excursionSaveDtoRequest);

  List<ExcursionResponse> findAll();

  Excursion findById(Long id);

  void update(ExcursionUpdateDtoRequest excursionUpdateDtoRequest);

  void deleteById(Long id);

  List<ExcursionResponse> findByPeriod(LocalDateTime start, LocalDateTime end);

  Integer findCountByPeriod(LocalDateTime start, LocalDateTime end);
}
