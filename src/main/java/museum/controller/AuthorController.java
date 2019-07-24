package museum.controller;

import museum.dao.AuthorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

  @Autowired private AuthorDao dao;

  @RequestMapping("/author")
  public String findAll(ModelMap modelMap) {
    modelMap.addAttribute("authors", dao.findAll());
    return "author";
  }
}
