package museum.controller;

import museum.dto.worker.WorkerEditDto;
import museum.dto.worker.WorkerSaveDto;
import museum.exception.BadIdException;
import museum.exception.BadNameException;
import museum.exception.EntityConstraintException;
import museum.exception.WorkerStatException;
import museum.service.HallService;
import museum.service.PostService;
import museum.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Controller class for 'worker' page.
 *
 * @author Rostyslav Khasanov
 * @version 1.0
 */
@Controller
@RequestMapping("/worker")
public class WorkerController {

  @Autowired private WorkerService workerService;

  @Autowired private HallService hallService;

  @Autowired private PostService postService;

  /**
   * Handles request to post worker into db.
   *
   * @param workerSaveDto worker request dto from jsp.
   */
  @PostMapping
  public String save(@Valid @ModelAttribute("workerForm") WorkerSaveDto workerSaveDto) {
    workerService.save(workerSaveDto);
    return "redirect:/worker";
  }

  /**
   * Handles request to get all workers.
   *
   * @param modelMap Redirect modelMap.
   * @return Path for page to continues processing the request and to be send as response.
   */
  @GetMapping
  public String findAll(ModelMap modelMap) {
    modelMap.addAttribute("workers", workerService.findAll());
    modelMap.addAttribute("posts", postService.findAll());
    return "worker/worker";
  }

  /**
   * Handles request to get worker by id.
   *
   * @param modelMap Redirect modelMap.
   * @param id worker id.
   * @return Path for page to continues processing the request and to be send as response.
   */
  @RequestMapping(
      method = RequestMethod.GET,
      params = {"id"})
  public String findById(@RequestParam @NotNull Long id, ModelMap modelMap) {
    try {
      modelMap.addAttribute("worker", workerService.findById(id));
      modelMap.addAttribute("halls", hallService.findByWorkerId(id));
      return "worker/workerInfo";
    } catch (BadIdException e) {
      modelMap.addAttribute("message", e.getMessage());
      return "errorMessage";
    }
  }

  /**
   * Handles request to get exhibits of worker.
   *
   * @param modelMap Redirect modelMap.
   * @param name Redirect modelMap.
   * @return Path page to continues processing the request and to be send as response.
   */
  @RequestMapping(
      method = RequestMethod.GET,
      params = {"name"})
  public String findWorkerExhibits(@RequestParam String name, ModelMap modelMap) {
    try {
      Long id = workerService.findWorkerIdByName(name);
      modelMap.addAttribute("worker", workerService.findById(id));
      modelMap.addAttribute("halls", hallService.findByWorkerId(id));
      return "worker/workerExhibits";
    } catch (BadNameException e) {
      modelMap.addAttribute("message", e.getMessage());
      return "errorMessage";
    }
  }

  /**
   * Handles request to get all workers with post gid.
   *
   * @param modelMap Redirect modelMap.
   * @return Path for tiled page to continues processing the request and to be send as response.
   */
  @GetMapping("/guides")
  public String findAllGuides(ModelMap modelMap) {
    modelMap.addAttribute("guides", workerService.findAllGuide());
    return "guide/gid";
  }

  /**
   * Handles request to get all guides which is free now.
   *
   * @param modelMap Redirect modelMap.
   * @return Path page to continues processing the request and to be send as response.
   */
  @GetMapping("/guides/free")
  public String findAllFreeGuides(ModelMap modelMap) {
    modelMap.addAttribute("guides", workerService.findAllFreeGuide());
    return "guide/gidFree";
  }

  /**
   * Handles request to get guides statistic.
   *
   * @param modelMap Redirect modelMap.
   * @return Path page to continues processing the request and to be send as response.
   */
  @GetMapping("/guides/stat")
  public String findGuidesStat(ModelMap modelMap) {
    try {
      modelMap.addAttribute("guides", workerService.findGuidesStat());
      return "guide/gidStat";
    } catch (WorkerStatException e) {
      modelMap.addAttribute("message", e.getMessage());
      return "errorMessage";
    }
  }

  /**
   * Handles request for redirect to addWorker page
   *
   * @param modelMap Redirect modelMap.
   * @return Path page to continues processing the request and to be send as response.
   */
  @RequestMapping("/add")
  public String addWorkerPage(ModelMap modelMap) {
    modelMap.addAttribute("posts", postService.findAll());
    return "worker/addWorker";
  }

  /**
   * Handles request to delete worker by id from DB.
   *
   * @param id worker id.
   */
  @GetMapping(value = "/delete", params = "id")
  public String deleteWorker(@RequestParam @NotNull Long id, ModelMap modelMap) {
    try {
      workerService.deleteById(id);
      return "redirect:/worker";
    } catch (EntityConstraintException | BadIdException e) {
      modelMap.addAttribute("message", e.getMessage());
      return "errorMessage";
    }
  }

  /**
   * Handles request to redirect on editWorker page.
   *
   * @param modelMap Redirect modelMap.
   * @param id worker id.
   * @return Path page to continues processing the request and to be send as response.
   */
  @GetMapping(value = "/edit", params = "id")
  public String editWorker(@RequestParam @NotNull Long id, ModelMap modelMap) {
    try {
      modelMap.addAttribute("worker", workerService.findById(id));
      modelMap.addAttribute("posts", postService.findAll());
      return "worker/addWorker";
    } catch (BadIdException e) {
      modelMap.addAttribute("message", e.getMessage());
      return "errorMessage";
    }
  }

  /**
   * Handles request to update worker information.
   *
   * @param dto worker dto from jsp.
   */
  @PostMapping("/update")
  public String update(@Valid @ModelAttribute("workerFormUpdate") WorkerEditDto dto) {
    workerService.update(dto);
    return "redirect:/worker";
  }
}
