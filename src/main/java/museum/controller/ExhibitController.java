package museum.controller;

import museum.dto.request.exhibit.ExhibitSaveDtoRequest;
import museum.dto.request.exhibit.ExhibitUpdateDtoRequest;
import museum.dto.response.exhibit.ExhibitDtoResponse;
import museum.dto.response.exhibit.ExhibitIdNameDtoResponse;
import museum.service.AuthorService;
import museum.service.ExhibitService;
import museum.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/exhibit")
public class ExhibitController {

  @Autowired private ExhibitService service;
  @Autowired private AuthorService authorService;
  @Autowired private WorkerService workerService;

  @GetMapping
  public String findAll(ModelMap modelMap) {
    List<ExhibitIdNameDtoResponse> authors = service.findAll();
    modelMap.addAttribute("exhibits", authors);
    return "exhibit/exhibits";
  }

  @GetMapping(params = "id")
  public String findById(@RequestParam Long id, ModelMap modelMap) {
    ExhibitDtoResponse exhibit = service.findById(id);
    modelMap.addAttribute("exhibit", exhibit);
    return "exhibit/exhibitInfo";
  }

  @PostMapping("/save")
  public void save(
      @Valid @ModelAttribute ExhibitSaveDtoRequest dto, HttpServletResponse httpServletResponse) {
    service.save(dto);
    httpServletResponse.setHeader("Location", "http://localhost:8080/exhibit");
    httpServletResponse.setStatus(302);
  }

  @PostMapping("/update")
  public void update(
      @Valid @ModelAttribute ExhibitUpdateDtoRequest dto, HttpServletResponse httpServletResponse) {
    service.update(dto);
    httpServletResponse.setHeader("Location", "http://localhost:8080/exhibit");
    httpServletResponse.setStatus(302);
  }

  @GetMapping("/delete")
  public void delete(@RequestParam Long id, HttpServletResponse httpServletResponse) {
    service.deleteById(id);
    httpServletResponse.setHeader("Location", "http://localhost:8080/exhibit");
    httpServletResponse.setStatus(302);
  }

  @RequestMapping("/add")
  public String addExhibitPage(ModelMap modelMap) {
    modelMap.addAttribute("authors", authorService.findAll());
    modelMap.addAttribute("workers", workerService.findAll());
    return "exhibit/addExhibit";
  }

  @RequestMapping(value = "/edit", params = "id")
  public String updateExhibitPage(@RequestParam Long id, ModelMap modelMap) {
    ExhibitDtoResponse exhibit = service.findById(id);
    modelMap.addAttribute("author", exhibit);
    return "exhibit/editExhibit";
  }
}
