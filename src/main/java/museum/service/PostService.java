package museum.service;

import museum.dto.request.post.PostRequestDto;
import museum.dto.response.post.PostDto;
import museum.dto.response.post.PostNameResponseDto;
import museum.dto.response.post.PostResponseDto;
import museum.entity.Post;

import java.util.List;

public interface PostService {

  void save(PostRequestDto postRequestDto);

  PostResponseDto findById(Long id);

  List<PostNameResponseDto> findAll();

  Post getOneById(Long id);
}
