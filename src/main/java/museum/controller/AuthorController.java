package museum.controller;

import museum.dto.author.AuthorFirstAndSecondNameDto;
import museum.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/author")
public class AuthorController {

  @Autowired private AuthorService service;

  @RequestMapping(method = RequestMethod.GET)
  public String findAll(ModelMap modelMap) {
    modelMap.addAttribute("authors", service.findAll());
    return "author/authors";
  }

  @RequestMapping(
      method = RequestMethod.GET,
      params = {"id"})
  public String findById(@RequestParam Long id, ModelMap modelMap) {
    modelMap.addAttribute("author", service.findById(id));
    return "author/authorInformation";
  }

  @RequestMapping(method = RequestMethod.POST)
  public String save(@Valid @ModelAttribute AuthorFirstAndSecondNameDto dto){
    service.save(dto);
    return "";
  }

  @RequestMapping(method = RequestMethod.PUT)
  public String update(@Valid @ModelAttribute AuthorFirstAndSecondNameDto dto){
    service.update(dto);
    return "";
  }

  @RequestMapping(method = RequestMethod.DELETE, params = "id")
  public String delete(@RequestParam Long id){
    service.deleteById(id);
    return "";
  }

}
