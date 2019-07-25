package museum.controller;

import museum.dao.AuthorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthorController {

  @Autowired private AuthorDao dao;

  @RequestMapping(value = "/author", method = RequestMethod.GET)
  public String findAll(ModelMap modelMap) {
    modelMap.addAttribute("authors", dao.findAll());
    return "author";
  }
}
