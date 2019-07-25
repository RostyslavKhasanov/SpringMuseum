package museum.controller;

import museum.service.impl.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/author")
public class AuthorController {

  /*@Autowired private AuthorServiceImpl service;

  @RequestMapping(method = RequestMethod.GET)
  public String findAll(ModelMap modelMap) {
    modelMap.addAttribute("authors", service.findAll());
    return "author";
  }

  @RequestMapping(
      method = RequestMethod.GET,
      params = {"id"})
  public String findById(@RequestParam Long id, ModelMap modelMap) {
    modelMap.addAttribute("author", service.findById(id));
    return "authorInformation";
  }*/
}
