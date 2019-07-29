package museum.controller;

import museum.dto.request.post.PostRequestDto;
import museum.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/post")
public class PostController {

  @Autowired private PostService postService;

  @PostMapping
  public void save(
      @Valid @ModelAttribute PostRequestDto postRequestDto,
      HttpServletResponse httpServletResponse) {
    postService.save(postRequestDto);
    httpServletResponse.setHeader("Location", "http://localhost:8080/worker");
    httpServletResponse.setStatus(302);
  }

  @RequestMapping("/add")
  public String addPostPage() {
    return "worker/addPost";
  }

  @GetMapping(value = "/delete", params = "id")
  public void deleteWorker(@RequestParam Long id, HttpServletResponse httpServletResponse) {
    postService.delete(id);
    httpServletResponse.setHeader("Location", "http://localhost:8080/worker");
    httpServletResponse.setStatus(302);
  }
}
