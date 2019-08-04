package museum.service;

import museum.dto.hall.HallSaveRequest;
import museum.dto.hall.HallUpdateRequest;
import museum.dto.hall.HallDtoResponse;
import museum.dto.hall.HallIdNameDtoResponse;
import museum.entity.Hall;
import museum.exception.BadIdException;
import museum.exception.EntityConstraintException;

import java.util.List;

public interface HallService {
    void save(HallSaveRequest dto);

    List<HallIdNameDtoResponse> findAll();

    HallDtoResponse findById(Long id) throws BadIdException;

    Hall getOneById(Long id) throws BadIdException;

    void update(HallUpdateRequest dto) throws BadIdException;

    void deleteById(Long id) throws BadIdException;

    List<HallDtoResponse> findByWorkerId(Long id);
}
