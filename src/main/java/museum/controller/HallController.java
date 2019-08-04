package museum.controller;

import museum.dto.hall.HallDtoResponse;
import museum.dto.hall.HallIdNameDtoResponse;
import museum.dto.hall.HallSaveRequest;
import museum.dto.hall.HallUpdateRequest;
import museum.dto.worker.WorkerNamesDto;
import museum.exception.BadIdException;
import museum.exception.EntityConstraintException;
import museum.service.HallService;
import museum.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller for Hall logic.
 *
 * @author Kateryna Horokh
 * @version 1.0
 */
@Controller
@RequestMapping("/hall")
public class HallController {

  @Autowired private HallService service;

  @Autowired private WorkerService workerService;

  /** Method that return all halls. */
  @GetMapping
  public String findAll(ModelMap modelMap) {
    List<HallIdNameDtoResponse> halls = service.findAll();
    modelMap.addAttribute("halls", halls);
    return "hall/halls";
  }

  /** Method that return excursion by id. */
  @GetMapping(params = "id")
  public String findById(@RequestParam Long id, ModelMap modelMap) {
    try {
      modelMap.addAttribute("hall", service.findById(id));
    } catch (BadIdException e) {
      modelMap.addAttribute("message", e.getMessage());
      return "errorMessage";
    }
    return "hall/hallInfo";
  }

  /** Method that save new hall. */
  @PostMapping("/save")
  public String save(@Valid @ModelAttribute HallSaveRequest dto) {
    service.save(dto);
    return "redirect:/hall";
  }

  /** Method that update hall. */
  @PostMapping("/update")
  public String update(@Valid @ModelAttribute HallUpdateRequest dto) {
    service.update(dto);
    return "redirect:/hall";
  }

  /** Method that delete hall. */
  @GetMapping(value = "/delete", params = "id")
  public String delete(@RequestParam Long id, ModelMap modelMap) {
    try {
      service.deleteById(id);
    } catch (BadIdException | EntityConstraintException e) {
      modelMap.addAttribute("message", e.getMessage());
      return "errorMessage";
    }
    return "redirect:/hall";
  }

  /** Method for jsp add page. */
  @RequestMapping("/add")
  public String addAuthorPage(ModelMap modelMap) {
    List<WorkerNamesDto> workers = workerService.findAll();
    modelMap.addAttribute("workers", workers);
    return "hall/addAndEditHall";
  }

  /** Method that update author page. */
  @RequestMapping(value = "/edit", params = "id")
  public String updateAuthorPage(@RequestParam Long id, ModelMap modelMap) {
    HallDtoResponse hall = service.findById(id);
    modelMap.addAttribute("hall", hall);
    List<WorkerNamesDto> workers = workerService.findAll();
    modelMap.addAttribute("workers", workers);
    return "hall/addAndEditHall";
  }
}
