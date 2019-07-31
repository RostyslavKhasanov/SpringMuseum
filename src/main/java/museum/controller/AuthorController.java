package museum.controller;

import museum.dto.author.AuthorFullDto;
import museum.dto.author.AuthorIdInitialsDto;
import museum.dto.author.AuthorInitialsDto;
import museum.exception.BadIdException;
import museum.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    List<AuthorIdInitialsDto> authors = service.findAll();
    modelMap.addAttribute("authors", authors);
    return "author/authors";
  }

  /** Method that return author by id. */
  @GetMapping(params = "id")
  public String findById(@RequestParam Long id, ModelMap modelMap) {
    try {
      AuthorFullDto author = service.findById(id);
      modelMap.addAttribute("author", author);
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
  public String update(@Valid @ModelAttribute AuthorIdInitialsDto dto) {
    service.update(dto);
    return "redirect:/author";
  }

  /** Method that delete author by id. */
  @GetMapping(value = "/delete", params = "id")
  public String delete(@RequestParam Long id) {
    service.deleteById(id);
    return "redirect:/author";
  }

  /** Method for jsp add page. */
  @RequestMapping("/add")
  public String addAuthorPage() {
    return "author/addAuthor";
  }

  /** Method for jsp edit page. */
  @RequestMapping(value = "/edit", params = "id")
  public String updateAuthorPage(@RequestParam Long id, ModelMap modelMap) {
    AuthorFullDto author = service.findById(id);
    modelMap.addAttribute("author", author);
    return "author/editAuthor";
  }
}
