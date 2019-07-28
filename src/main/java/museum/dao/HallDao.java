package museum.dao;

import museum.dto.response.hall.HallDtoResponse;
import museum.entity.Hall;

import java.util.List;

public interface HallDao extends ElementDao<Hall> {

    List<HallDtoResponse> findHalLByWorkerId(Long workerId);

}
