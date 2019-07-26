package museum.dao;

import museum.dto.hall.response.HallResponse;
import museum.entity.Hall;

import java.util.List;

public interface HallDao extends ElementDao<Hall> {

    List<HallResponse> findHalLByWorkerId(Long workerId);

}
