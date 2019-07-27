package museum.service;

import museum.dto.post.PostDto;
import museum.entity.Post;

import java.util.List;

public interface PostService {

  void save(PostDto postDto);

  Post findById(Long id);

  List<Post> findAll();
}
