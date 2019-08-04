package museum.controller;

import museum.dto.excursion.ExcursionFullDto;
import museum.dto.excursion.ExcursionIdNameDto;
import museum.dto.excursion.ExcursionSaveDto;
import museum.dto.excursion.ExcursionUpdateDto;
import museum.dto.worker.WorkerNamesDto;
import museum.exception.BadIdException;
import museum.exception.BadRequestForInputDate;
import museum.service.ExcursionService;
import museum.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Controller for Excursion logic.
 *
 * @author Kateryna Horokh
 * @version 1.0
 */
@Controller
@RequestMapping("/excursion")
public class ExcursionController {

  @Autowired private ExcursionService excursionService;

  @Autowired private WorkerService workerService;

  /** Method that return all excursions. */
  @GetMapping
  public String findAll(ModelMap modelMap) {
    modelMap.addAttribute("excursions", excursionService.findAll());
    return "excursion/excursionsInfo";
  }

  /** Method for giving form for searching excursions in time period based on given input. */
  @RequestMapping("/byPeriodForm")
  public String showFormPage(ModelMap modelMap) {
    return "excursion/excursionForm";
  }

  /**
   * Method for searching excursions in time period based on given input.
   *
   * @param from start of time slot to search in
   * @param to end of time slot to search in
   * @exception Exception
   */
  @RequestMapping(
      method = RequestMethod.GET,
      value = "/byPeriod",
      params = {"start", "end"})
  public String findByPeriod(
      @RequestParam(name = "start") String from,
      @RequestParam(name = "end") String to,
      ModelMap modelMap) {
    try {
      String fromS = from.replaceAll("T", " ");
      String toS = to.replaceAll("T", " ");
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
      LocalDateTime begin = LocalDateTime.parse(fromS, formatter);
      LocalDateTime end = LocalDateTime.parse(toS, formatter);
      List<ExcursionIdNameDto> excursions = excursionService.findByPeriod(begin, end);
      modelMap.addAttribute("excursions", excursions);

      int excursionsStatistic = excursionService.findCountByPeriod(begin, end);
      modelMap.addAttribute("excursionsStatistic", excursionsStatistic);
      return "excursion/excursions";
    } catch (BadRequestForInputDate e) {
      modelMap.addAttribute("message", e.getMessage());
      return "errorMessage";
    }
  }

  /** Method that return excursion by id. */
  @GetMapping(params = "id")
  public String findById(@RequestParam @NotNull Long id, ModelMap modelMap) {
    try {
      modelMap.addAttribute("excursion", excursionService.findById(id));
    } catch (BadIdException e) {
      modelMap.addAttribute("message", e.getMessage());
      return "errorMessage";
    }
    return "excursion/aboutExcursion";
  }

  /** Method for jsp edit page. */
  @RequestMapping(value = "/edit", params = "id")
  public String updateExhibitPage(@RequestParam @NotNull Long id, ModelMap modelMap) {
    ExcursionFullDto excursion = excursionService.findById(id);
    modelMap.addAttribute("excursion", excursion);
    modelMap.addAttribute("workers", workerService.findAll());
    return "excursion/addAndEditExcursion";
  }

  /** Method that update excursion. */
  @PostMapping("/update")
  public String update(@Valid @ModelAttribute ExcursionUpdateDto dto, ModelMap modelMap) {
    try {
      excursionService.update(dto);
    } catch (BadIdException | BadRequestForInputDate e) {
      modelMap.addAttribute("message", e.getMessage());
      return "errorMessage";
    }
    return "redirect:/excursion";
  }

  /** Method that save new excursion. */
  @PostMapping("/save")
  public String save(@Valid @ModelAttribute ExcursionSaveDto dto) {
    excursionService.save(dto);
    return "redirect:/excursion";
  }

  /** Method for jsp add page. */
  @RequestMapping("/add")
  public String addExcursionPage(ModelMap modelMap) {
    List<WorkerNamesDto> workers = workerService.findAll();
    modelMap.addAttribute("workers", workers);
    return "excursion/addAndEditExcursion";
  }

  /** Method that delete excursion. */
  @GetMapping(value = "/delete", params = "id")
  public String delete(@RequestParam @NotNull Long id, ModelMap modelMap) {
    try {
      excursionService.deleteById(id);
    } catch (BadIdException e) {
      modelMap.addAttribute("message", e.getMessage());
      return "errorMessage";
    }
    return "redirect:/excursion";
  }
}
