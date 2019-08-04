package museum.service;

import museum.dto.excursion.ExcursionFullDto;
import museum.dto.excursion.ExcursionIdNameDto;
import museum.dto.excursion.ExcursionSaveDto;
import museum.dto.excursion.ExcursionUpdateDto;
import museum.entity.Excursion;
import museum.exception.BadIdException;
import museum.exception.BadRequestForInputDate;

import java.time.LocalDateTime;
import java.util.List;

public interface ExcursionService {

  void save(ExcursionSaveDto excursionSaveDto);

  List<ExcursionIdNameDto> findAll();

  ExcursionFullDto findById(Long id) throws BadIdException;

  Excursion getOneById(Long id) throws BadIdException;

  void update(ExcursionUpdateDto excursionUpdateDto) throws BadRequestForInputDate, BadIdException;

  void deleteById(Long id) throws BadIdException;

  List<ExcursionIdNameDto> findByPeriod(LocalDateTime begin, LocalDateTime end) throws BadRequestForInputDate;

  Integer findCountByPeriod(LocalDateTime start, LocalDateTime end);
}
