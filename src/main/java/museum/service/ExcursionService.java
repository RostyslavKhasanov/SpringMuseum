package museum.service;

import museum.dto.excursion.ExcursionRequest;
import museum.dto.excursion.ExcursionResponse;
import museum.entity.Excursion;

import java.time.LocalDateTime;
import java.util.List;

public interface ExcursionService {

    ExcursionResponse save(ExcursionRequest excursionRequest);

    List<ExcursionResponse> findAll();

    Excursion findById(Long id);

    ExcursionResponse update(ExcursionRequest excursionRequest);

    void deleteById(Long id);

    List<ExcursionResponse> findByPeriod(LocalDateTime start, LocalDateTime end);
}
