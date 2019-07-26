package museum.controller;

import museum.service.HallService;
import museum.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/worker")
public class WorkerController {

  @Autowired private WorkerService workerService;

  @Autowired
  private HallService hallService;

  @GetMapping
  public String findAll(ModelMap modelMap) {
    modelMap.addAttribute("workers", workerService.findAll());
    return "worker/worker";
  }

  @RequestMapping(
      method = RequestMethod.GET,
      params = {"id"})
  public String findById(@RequestParam Long id, ModelMap modelMap) {
    modelMap.addAttribute("worker", workerService.findById(id));
    modelMap.addAttribute("halls", hallService.findByWorkerId(id));
    return "worker/workerInfo";
  }

  @RequestMapping(
          method = RequestMethod.GET,
          params = {"name"})
  public String findWorkerExhibits(@RequestParam String name, ModelMap modelMap) {
    Long id = workerService.findWorkerIdByName(name);
    modelMap.addAttribute("worker", workerService.findById(id));
    modelMap.addAttribute("halls", hallService.findByWorkerId(id));
    return "worker/workerExhibits";
  }
}
