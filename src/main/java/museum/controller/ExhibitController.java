package museum.controller;

import museum.dto.request.exhibit.ExhibitDto;
import museum.dto.request.exhibit.ExhibitNameDto;
import museum.dto.request.exhibit.ExhibitSaveDtoRequest;
import museum.dto.response.exhibit.ExhibitDtoResponse;
import museum.service.ExhibitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/exhibit")
public class ExhibitController {

  @Autowired private ExhibitService service;

  @RequestMapping(method = RequestMethod.GET)
  public String findAll(ModelMap modelMap) {
    List<ExhibitNameDto> authors = service.findAll();
    modelMap.addAttribute("exhibits", authors);
    return "exhibit/exhibits";
  }

  @RequestMapping(
      method = RequestMethod.GET,
      params = {"id"})
  public String findById(@RequestParam Long id, ModelMap modelMap) {
    ExhibitDtoResponse exhibit = service.findById(id);
    modelMap.addAttribute("exhibit", exhibit);
    return "exhibit/exhibitInfo";
  }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public void save(@Valid @ModelAttribute ExhibitSaveDtoRequest dto, HttpServletResponse httpServletResponse) {
    service.save(dto);
    httpServletResponse.setHeader("Location", "http://localhost:8080/exhibit");
    httpServletResponse.setStatus(302);
  }

  @RequestMapping(value = "/update", method = RequestMethod.POST)
  public void update(
      @Valid @ModelAttribute ExhibitDto dto, HttpServletResponse httpServletResponse) {
    service.update(dto);
    httpServletResponse.setHeader("Location", "http://localhost:8080/exhibit");
    httpServletResponse.setStatus(302);
  }

  @RequestMapping(value = "/delete", method = RequestMethod.GET, params = "id")
  public void delete(@RequestParam Long id, HttpServletResponse httpServletResponse) {
    service.deleteById(id);
    httpServletResponse.setHeader("Location", "http://localhost:8080/exhibit");
    httpServletResponse.setStatus(302);
  }
}
