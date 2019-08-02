package museum.controller;

import museum.dto.excursion.ExcursionResponse;
import museum.dto.excursion.ExcursionSaveDto;
import museum.dto.excursion.ExcursionUpdateDto;
import museum.dto.worker.WorkerFirstSecondNameDtoResponse;
import museum.exception.BadIdException;
import museum.exception.BadRequestForInputDate;
import museum.service.ExcursionService;
import museum.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
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
    List<ExcursionResponse> excursions = excursionService.findAll();
    modelMap.addAttribute("excursions", excursions);
    return "excursion/excursionsInfo";
  }

  /**
   * Method for giving form for searching excursions in time period based on given input.
   *
   * @return "/excursion/excursionForm"
   */
  @RequestMapping("/byPeriodForm")
  public String showFormPage(ModelMap modelMap) {
    return "/excursion/excursionForm";
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
      LocalDateTime start = LocalDateTime.parse(fromS, formatter);
      LocalDateTime end = LocalDateTime.parse(toS, formatter);
      List<ExcursionResponse> excursions = excursionService.findByPeriod(start, end);
      modelMap.addAttribute("excursions", excursions);

      int excursionsStatistic = excursionService.findCountByPeriod(start, end);
      modelMap.addAttribute("excursionsStatistic", excursionsStatistic);
      return "/excursion/excursions";
    } catch (BadRequestForInputDate e) {
      modelMap.addAttribute("message", e.getMessage());
      return "errorMessage";
    }
  }

  /** Method that return excursion by id. */
  @GetMapping(params = "id")
  public String findById(@RequestParam Long id, ModelMap modelMap) {
    try {
      ExcursionResponse excursion = excursionService.findById(id);
      modelMap.addAttribute("exhibit", excursion);
    } catch (BadIdException e) {
      modelMap.addAttribute("message", e.getMessage());
      return "errorMessage";
    }
    return "excursion/aboutExcursion";
  }

  /** Method for jsp edit page. */
  @RequestMapping(value = "/edit", params = "id")
  public String updateExhibitPage(@RequestParam Long id, ModelMap modelMap) {
    ExcursionResponse excursion = excursionService.findById(id);
    modelMap.addAttribute("excursion", excursion);
    modelMap.addAttribute("workers", workerService.findAll());
    return "excursion/editExcursion";
  }

  /** Method that update excursion. */
  @PostMapping("/update")
  public String update(@Valid @ModelAttribute ExcursionUpdateDto dto) {
    excursionService.update(dto);
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
    //    try {
    List<WorkerFirstSecondNameDtoResponse> workers = workerService.findAll();
    modelMap.addAttribute("workers", workers);
    return "excursion/addExcursion";
    //    } catch (Exception e) {
    //      return "errorMessage";
    //    }
  }

  /** Method that delete excursion. */
  @PostMapping(value = "/delete", params = "id")
  public String delete(@RequestParam Long id) {
    excursionService.deleteById(id);
    return "redirect:/excursion";
  }
}
