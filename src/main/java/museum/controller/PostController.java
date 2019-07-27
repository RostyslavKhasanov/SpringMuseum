package museum.controller;

import museum.dto.post.PostDto;
import museum.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/post")
public class PostController {

  @Autowired private PostService postService;

  @PostMapping
  public String save(@RequestParam(name = "Name") String name) {
    PostDto postDto = new PostDto();
    postDto.setName(name);
    postService.save(postDto);
    return "worker/addPost";
  }

  @RequestMapping("/add")
  public String addPostPage() {
    return "worker/addPost";
  }
}
