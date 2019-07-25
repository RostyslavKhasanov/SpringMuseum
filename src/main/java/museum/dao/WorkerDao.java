package museum.dao;

import museum.entity.Worker;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class WorkerDao extends ElementDaoImpl<Worker> {
    public WorkerDao() {
        super(Worker.class);
    }
}
