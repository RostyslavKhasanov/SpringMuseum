package museum.controller;

import museum.dto.request.excursion.ExcursionSaveDtoRequest;
import museum.dto.request.excursion.ExcursionUpdateDtoRequest;
import museum.dto.response.excursion.ExcursionResponse;
import museum.service.ExcursionService;
import museum.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("/excursion")
public class ExcursionController {

  @Autowired private ExcursionService excursionService;

  @Autowired private WorkerService workerService;


  @GetMapping
  public String findAll(ModelMap modelMap) {
    List<ExcursionResponse> excursions = excursionService.findAll();
    modelMap.addAttribute("excursions", excursions);
    return "excursion/excursions";
  }

  @RequestMapping("/byPeriodForm")
  public String showFormPage(ModelMap modelMap){
    return "/excursion/excursionForm";
  }

  @RequestMapping(
      value = "/byPeriod",
      method = RequestMethod.GET,
      params = {"start", "end"})
  public String findByPeriod(
          @RequestParam(name="start") String from,
          @RequestParam(name="end") String to, ModelMap modelMap) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    LocalDateTime start = LocalDateTime.parse(from, formatter);
    LocalDateTime end = LocalDateTime.parse(to, formatter);

    List<ExcursionResponse> excursions = excursionService.findByPeriod(start, end);
    modelMap.addAttribute("excursions", excursions);
    return "/excursion/excursionForm";
  }

  @PostMapping("/save")
  public void save(
      @Valid @ModelAttribute ExcursionSaveDtoRequest dto, HttpServletResponse httpServletResponse) {
    excursionService.save(dto);
    httpServletResponse.setHeader("Location", "http://localhost:8080/excursion");
    httpServletResponse.setStatus(302);
  }

  @RequestMapping("/add")
  public String addExcursionPage(ModelMap modelMap) {
    modelMap.addAttribute("workers", workerService.findAll());
    return "/excursion/addExcursion";
  }

  @PostMapping("/update")
  public void update(
      @Valid @ModelAttribute ExcursionUpdateDtoRequest dto,
      HttpServletResponse httpServletResponse) {
    excursionService.update(dto);
    httpServletResponse.setHeader("Location", "http://localhost:8080/excursion");
    httpServletResponse.setStatus(302);
  }

  @PostMapping("/delete")
  public String deleteExcursion(@RequestParam(name = "id") Long id, ModelMap modelMap) {
    excursionService.deleteById(id);
    modelMap.addAttribute("message", "Excursion with id " + id + " is deleted!");
    return "excursion/successful";
  }

  @RequestMapping(
      value = "/stat",
      params = {"start", "end"})
  public String findCountByPeriod(
          @RequestParam String from, @RequestParam String to, ModelMap modelMap) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    LocalDateTime start = LocalDateTime.parse(from, formatter);
    LocalDateTime end = LocalDateTime.parse(to, formatter);
    int excursionsStatistic = excursionService.findCountByPeriod(start, end);
    modelMap.addAttribute("excursionsStatistic", excursionsStatistic);
    return "excursion/excursionsStatistic";
  }
}
