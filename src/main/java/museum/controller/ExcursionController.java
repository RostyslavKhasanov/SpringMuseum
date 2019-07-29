package museum.controller;

import museum.dto.response.excursion.ExcursionResponse;
import museum.service.ExcursionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/excursion")
public class ExcursionController {

  @Autowired private ExcursionService excursionService;

  @RequestMapping(
      method = RequestMethod.GET,
      params = {"start", "end"})
  public String findByPeriod(
          @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") LocalDateTime start,
          @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") LocalDateTime end,
          ModelMap modelMap) {
    modelMap.addAttribute("start", start);
    modelMap.addAttribute("end", end);

    List<ExcursionResponse> excursions = excursionService.findByPeriod(start, end);
    modelMap.addAttribute("excursion", excursions);
    return "excursion/excursionInfo";
  }

  @GetMapping
  public String findAll(ModelMap modelMap) {
    modelMap.addAttribute("excursions", excursionService.findAll());
    return "excursion/excursion";
  }

  @RequestMapping(method = RequestMethod.DELETE, params = "id")
  public String delete(@RequestParam Long id) {
    excursionService.deleteById(id);
    return "";
  }
}
