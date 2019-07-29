package museum.service;

import museum.dto.request.post.PostRequestDto;
import museum.dto.response.post.PostResponseDto;
import museum.entity.Post;

import java.util.List;

public interface PostService {

  void save(PostRequestDto postRequestDto);

  PostResponseDto findById(Long id);

  List<PostResponseDto> findAll();

  Post getOneById(Long id);

  void delete(Long id);
}
