package museum.service;

import museum.dto.request.excursion.ExcursionSaveDtoRequest;
import museum.dto.request.excursion.ExcursionUpdateDtoRequest;
import museum.dto.response.excursion.ExcursionResponse;
import museum.entity.Excursion;
import museum.exception.BadRequestForInputDate;

import java.time.LocalDateTime;
import java.util.List;

public interface ExcursionService {

  void save(ExcursionSaveDtoRequest excursionSaveDtoRequest);

  List<ExcursionResponse> findAll();

  ExcursionResponse findById(Long id);

  Excursion getOneById(Long id);

  void update(ExcursionUpdateDtoRequest excursionUpdateDtoRequest);

  void deleteById(Long id);

  List<ExcursionResponse> findByPeriod(LocalDateTime start, LocalDateTime end) throws BadRequestForInputDate;

  Integer findCountByPeriod(LocalDateTime start, LocalDateTime end);
}
