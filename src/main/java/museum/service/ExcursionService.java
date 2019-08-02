package museum.service;

import museum.dto.excursion.ExcursionResponse;
import museum.dto.excursion.ExcursionSaveDto;
import museum.dto.excursion.ExcursionUpdateDto;
import museum.entity.Excursion;
import museum.exception.BadRequestForInputDate;

import java.time.LocalDateTime;
import java.util.List;

public interface ExcursionService {

  void save(ExcursionSaveDto excursionSaveDto);

  List<ExcursionResponse> findAll();

  ExcursionResponse findById(Long id);

  Excursion getOneById(Long id);

  void update(ExcursionUpdateDto excursionUpdateDto);

  void deleteById(Long id);

  List<ExcursionResponse> findByPeriod(LocalDateTime start, LocalDateTime end) throws BadRequestForInputDate;

  Integer findCountByPeriod(LocalDateTime start, LocalDateTime end);
}
