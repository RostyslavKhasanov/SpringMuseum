package museum.controller;

import museum.dao.WorkerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/worker")
public class WorkerController {

    @Autowired
    private WorkerDao workerDao;

    public String findAll(ModelMap modelMap) {
        modelMap.addAttribute("workers", workerDao.findAll());
        return "workers/workers";
    }

}
