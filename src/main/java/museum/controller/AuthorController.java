package museum.controller;

import museum.dto.author.AuthorIdInitialsDto;
import museum.dto.author.AuthorInitialsDto;
import museum.exception.BadIdException;
import museum.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Controller for Author logic.
 *
 * @author Nazar Stasyuk
 * @version 1.0
 */
@Controller
@RequestMapping("/author")
public class AuthorController {

  @Autowired private AuthorService service;

  /** Method that return all authors. */
  @GetMapping
  public String findAll(ModelMap modelMap) {
    modelMap.addAttribute("authors", service.findAll());
    return "author/authors";
  }

  /** Method that return author by id. */
  @GetMapping(params = "id")
  public String findById(@RequestParam Long id, ModelMap modelMap) {
    try {
      modelMap.addAttribute("author", service.findById(id));
    } catch (BadIdException e) {
      modelMap.addAttribute("message", e.getMessage());
      return "errorMessage";
    }
    return "author/authorInfo";
  }

  /** Method that save new author. */
  @PostMapping("/save")
  public String save(@Valid @ModelAttribute AuthorInitialsDto dto) {
    service.save(dto);
    return "redirect:/author";
  }

  /** Method that update author. */
  @PostMapping("/update")
  public String update(@Valid @ModelAttribute AuthorIdInitialsDto dto, ModelMap modelMap) {
    try {
      service.update(dto);
    } catch (BadIdException e) {
      modelMap.addAttribute("message", e.getMessage());
      return "errorMessage";
    }
    return "redirect:/author";
  }

  /** Method that delete author by id. */
  @GetMapping(value = "/delete", params = "id")
  public String delete(@RequestParam Long id, ModelMap modelMap) {
    try {
      service.deleteById(id);
    } catch (BadIdException e) {
      modelMap.addAttribute("message", e.getMessage());
      return "errorMessage";
    }
    return "redirect:/author";
  }

  /** Method for jsp add page. */
  @RequestMapping("/add")
  public String addAuthorPage() {
    return "author/addAndEditAuthor";
  }

  /** Method for jsp edit page. */
  @RequestMapping(value = "/edit", params = "id")
  public String updateAuthorPage(@RequestParam Long id, ModelMap modelMap) {
    findById(id, modelMap);
    return "author/addAndEditAuthor";
  }
}
