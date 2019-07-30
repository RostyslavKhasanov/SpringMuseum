package museum.dao;

import museum.entity.Hall;

import java.util.List;

public interface HallDao extends ElementDao<Hall> {

    List<Hall> findHalLByWorkerId(Long workerId);

}
