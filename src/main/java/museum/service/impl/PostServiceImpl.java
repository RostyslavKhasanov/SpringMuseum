package museum.service.impl;

import museum.dao.PostDao;
import museum.dto.request.post.PostRequestDto;
import museum.dto.response.post.PostDto;
import museum.dto.response.post.PostNameResponseDto;
import museum.dto.response.post.PostResponseDto;
import museum.entity.Post;
import museum.exception.BadIdException;
import museum.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

  @Autowired private PostDao postDao;

  @Transactional
  @Override
  public void save(PostRequestDto postRequestDto) {
    Post post = postRequestDtoToPost(postRequestDto);
    postDao.save(post);
  }

  @Transactional
  @Override
  public PostResponseDto findById(Long id) {
    Post post = postDao.findById(id);
    return postToPostResponseDto(post);
  }

  @Override
  public List<PostNameResponseDto> findAll() {
    return postDao.findAll().stream().map(PostNameResponseDto::new).collect(Collectors.toList());
  }

  @Override
  public Post getOneById(Long id) {
    Post post = new Post();
    if (post == null) {
      throw new BadIdException("Post with id " + id + " doesn't exist");
    }
    return post;
  }

  private Post postRequestDtoToPost(PostRequestDto postRequestDto) {
    Post post = new Post();
    post.setName(postRequestDto.getName());
    return post;
  }

  private PostResponseDto postToPostResponseDto(Post post) {
    PostResponseDto postResponseDto = new PostResponseDto();
    postResponseDto.setId(post.getId());
    postResponseDto.setName(post.getName());
    return new PostResponseDto();
  }
}
