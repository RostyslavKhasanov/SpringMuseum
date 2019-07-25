package museum.controller;

import museum.dao.impl.ExhibitDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/exhibit")
public class ExhibitController {

 /* @Autowired private ExhibitDaoImpl dao;

  @RequestMapping(method = RequestMethod.GET)
  public String findAll(ModelMap modelMap) {
    modelMap.addAttribute("exhibits", dao.findAll());
    return "exhibit";
  }*/
}
