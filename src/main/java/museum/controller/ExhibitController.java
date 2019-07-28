package museum.controller;

import museum.dto.exhibit.ExhibitDto;
import museum.service.ExhibitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/exhibit")
public class ExhibitController {

  @Autowired private ExhibitService service;

  @RequestMapping(method = RequestMethod.GET)
  public String findAll(ModelMap modelMap) {
    modelMap.addAttribute("exhibits", service.findAll());
    return "exhibit/exhibits";
  }

  @RequestMapping(
      method = RequestMethod.GET,
      params = {"id"})
  public String findById(@RequestParam Long id, ModelMap modelMap) {
    modelMap.addAttribute("exhibit", service.findById(id));
    return "exhibit/exhibitInfo";
  }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public String save(@Valid @ModelAttribute ExhibitDto dto) {
    service.save(dto);
    return "exhibit/exhibits";
  }

  @RequestMapping(value = "/update", method = RequestMethod.POST)
  public String update(@Valid @ModelAttribute ExhibitDto dto) {
    service.update(dto);
    return "exhibit/exhibits";
  }

  @RequestMapping(value = "/delete", method = RequestMethod.GET, params = "id")
  public String delete(@RequestParam Long id) {
    service.deleteById(id);
    return "exhibit/exhibits";
  }
}
