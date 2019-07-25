package museum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exhibit")
public class ExhibitController {

  /*@Autowired private ExhibitDao dao;

  @RequestMapping(method = RequestMethod.GET)
  public String findAll(ModelMap modelMap) {
    modelMap.addAttribute("exhibits", dao.findAll());
    return "exhibit/exhibit";
  }*/
}
