package museum.controller;

import museum.dto.request.worker.WorkerAddRequestDto;
import museum.dto.request.worker.WorkerUpdateRequestDto;
import museum.service.HallService;
import museum.service.PostService;
import museum.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/worker")
public class WorkerController {

  @Autowired private WorkerService workerService;

  @Autowired private HallService hallService;

  @Autowired private PostService postService;

  @PostMapping
  public void save(
      @Valid @ModelAttribute("workerForm") WorkerAddRequestDto workerAddRequestDto,
      HttpServletResponse httpServletResponse) {
    workerService.save(workerAddRequestDto);
    httpServletResponse.setHeader("Location", "http://localhost:8080/worker");
    httpServletResponse.setStatus(302);
  }

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
    try {
      Long id = workerService.findWorkerIdByName(name);
      modelMap.addAttribute("worker", workerService.findById(id));
      modelMap.addAttribute("halls", hallService.findByWorkerId(id));
      return "worker/workerExhibits";
    } catch (Exception e) {
      modelMap.addAttribute("message", e.getMessage());
      return "error";
    }
  }

  @GetMapping("/guides")
  public String findAllGuides(ModelMap modelMap) {
    modelMap.addAttribute("guides", workerService.findAllGuide());
    return "guide/gid";
  }

  @GetMapping("/guides/free")
  public String findAllFreeGuides(ModelMap modelMap) {
    modelMap.addAttribute("guides", workerService.findAllFreeGuide());
    return "guide/gidFree";
  }

  @GetMapping("/guides/stat")
  public String findGuidesStat(ModelMap modelMap) {
    modelMap.addAttribute("guides", workerService.findGuidesStat());
    return "guide/gidStat";
  }

  @RequestMapping("/add")
  public String addWorkerPage(ModelMap modelMap) {
    modelMap.addAttribute("posts", postService.findAll());
    return "worker/addWorker";
  }

  @GetMapping(value = "/delete", params = "id")
  public void deleteWorker(@RequestParam Long id, HttpServletResponse httpServletResponse) {
    workerService.deleteById(id);
    httpServletResponse.setHeader("Location", "http://localhost:8080/worker");
    httpServletResponse.setStatus(302);
  }

  @GetMapping(value = "/edit", params = "id")
  public String editWorker(@RequestParam Long id,ModelMap modelMap) {
    modelMap.addAttribute("worker", workerService.findById(id));
    modelMap.addAttribute("posts", postService.findAll());
    return "worker/editWorker";
  }

  @PostMapping("/update")
  public void update(
          @Valid @ModelAttribute("workerFormUpdate") WorkerUpdateRequestDto dto, HttpServletResponse httpServletResponse) {
    workerService.update(dto);
    httpServletResponse.setHeader("Location", "http://localhost:8080/worker");
    httpServletResponse.setStatus(302);
  }
}
