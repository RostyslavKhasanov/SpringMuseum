package museum.controller;

import museum.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/worker")
public class WorkerController {

  @Autowired private WorkerService workerService;

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
    return "worker/workerInfo";
  }
}
