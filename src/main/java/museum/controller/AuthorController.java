package museum.controller;

import museum.dto.request.author.AuthorSaveDtoRequest;
import museum.dto.request.author.AuthorUpdateDtoRequest;
import museum.dto.response.author.AuthorDtoResponse;
import museum.dto.response.author.AuthorIdFirstSecondNameDtoResponse;
import museum.service.AuthorService;
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
@RequestMapping("/author")
public class AuthorController {

  @Autowired private AuthorService service;

  @RequestMapping(method = RequestMethod.GET)
  public String findAll(ModelMap modelMap) {
    List<AuthorIdFirstSecondNameDtoResponse> authors = service.findAll();
    modelMap.addAttribute("authors", authors);
    return "author/authors";
  }

  @RequestMapping(
      method = RequestMethod.GET,
      params = {"id"})
  public String findById(@RequestParam Long id, ModelMap modelMap) {
    AuthorDtoResponse author = service.findById(id);
    modelMap.addAttribute("author", author);
    return "author/authorInfo";
  }

  @RequestMapping(value = "/save", method = RequestMethod.POST)
  public void save(
      @Valid @ModelAttribute AuthorSaveDtoRequest dto, HttpServletResponse httpServletResponse) {
    service.save(dto);
    httpServletResponse.setHeader("Location", "http://localhost:8080/author");
    httpServletResponse.setStatus(302);
  }

  @RequestMapping(value = "/update", method = RequestMethod.POST)
  public void update(
      @Valid @ModelAttribute AuthorUpdateDtoRequest dto, HttpServletResponse httpServletResponse) {
    service.update(dto);
    httpServletResponse.setHeader("Location", "http://localhost:8080/author");
    httpServletResponse.setStatus(302);
  }

  @RequestMapping(value = "/delete", method = RequestMethod.GET, params = "id")
  public void delete(@RequestParam Long id, HttpServletResponse httpServletResponse) {
    service.deleteById(id);
    httpServletResponse.setHeader("Location", "http://localhost:8080/author");
    httpServletResponse.setStatus(302);
  }
}
