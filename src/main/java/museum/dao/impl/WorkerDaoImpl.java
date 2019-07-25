package museum.dao.impl;

import museum.dao.ElementDaoImpl;
import museum.dao.WorkerDao;
import museum.entity.Worker;
import org.springframework.stereotype.Repository;

@Repository
public class WorkerDaoImpl extends ElementDaoImpl<Worker> implements WorkerDao {
    public WorkerDaoImpl() {
        super(Worker.class);
    }
}
