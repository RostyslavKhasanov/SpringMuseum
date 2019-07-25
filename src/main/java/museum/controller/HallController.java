package museum.controller;

import museum.dto.hall.request.HallRequest;
import museum.service.ExhibitService;
import museum.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/hall")
public class HallController {

  @Autowired private HallService hallService;

  @Autowired private ExhibitService exhibitService;

  @GetMapping
  public String findAll(ModelMap modelMap) {
    modelMap.addAttribute("halls", hallService.findAll());
    return "hall";
  }

  @RequestMapping(
      method = RequestMethod.GET,
      params = {"id"})
  public String findExcursionsByHallId(@RequestParam Long id, ModelMap modelMap) {
    modelMap.addAttribute("hall", exhibitService.findByHallId(id));
    return "hall/exhibitsByHall";
  }

  @RequestMapping(method = RequestMethod.POST)
  public String save(@Valid @ModelAttribute HallRequest hallRequest) {
    hallService.save(hallRequest);
    return "";
  }

  @RequestMapping(method = RequestMethod.PUT)
  public String update(@Valid @ModelAttribute HallRequest hallRequest) {
    hallService.update(hallRequest);
    return "";
  }

  @RequestMapping(method = RequestMethod.DELETE, params = "id")
  public String delete(@RequestParam Long id) {
    hallService.deleteById(id);
    return "";
  }
}
