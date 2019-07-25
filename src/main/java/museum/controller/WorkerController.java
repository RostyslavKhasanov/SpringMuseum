package museum.controller;

import museum.dao.WorkerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class WorkerController {

    @Autowired
    private WorkerDao workerDao;


}
