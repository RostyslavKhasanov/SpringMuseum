package museum.service;

import museum.dto.hall.HallSaveRequest;
import museum.dto.hall.HallUpdateRequest;
import museum.dto.hall.HallDtoResponse;
import museum.dto.hall.HallIdNameDtoResponse;
import museum.entity.Hall;

import java.util.List;

public interface HallService {
    void save(HallSaveRequest dto);

    List<HallIdNameDtoResponse> findAll();

    HallDtoResponse findById(Long id);

    Hall getOneById(Long id);

    void update(HallUpdateRequest dto);

    void deleteById(Long id);

    List<HallDtoResponse> findByWorkerId(Long id);
}
