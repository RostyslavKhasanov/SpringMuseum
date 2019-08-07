package museum.dao;

import museum.entity.Hall;

import java.util.List;

/**
 * DAO interface for Hall entity.
 *
 * @author Kateryna Horokh
 * @version 1.0
 */
public interface HallDao extends ElementDao<Hall> {

    /**
     * Gets halls by worker id.
     *
     * @param workerId worker id.
     * @return List of Hall.
     */
    List<Hall> findHalLByWorkerId(Long workerId);

}
