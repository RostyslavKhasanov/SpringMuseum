package museum.controller;

import museum.dto.post.PostDto;
import museum.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Controller class for 'post' page.
 *
 * @author Rostyslav Khasanov
 * @version 1.0
 */
@Controller
@RequestMapping("/post")
public class PostController {

  @Autowired private PostService postService;

  /**
   * Handles request to post post into db.
   *
   * @param postRequestDto post request dto from jsp.
   */
  @PostMapping
  public String save(
      @Valid @ModelAttribute PostDto postDto) {
    postService.save(postDto);
    return "redirect:/worker";
  }

  /** Handles request to redirect on addPost page. */
  @RequestMapping("/add")
  public String addPostPage() {
    return "worker/addPost";
  }

  /**
   * Handles request to delete post by id from db.
   *
   * @param id post id.
   */
  @GetMapping(value = "/delete", params = "id")
  public String deleteWorker(@RequestParam Long id) {
    postService.delete(id);
    return "redirect:/worker";
  }
}
