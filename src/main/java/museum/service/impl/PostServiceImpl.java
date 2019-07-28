package museum.service.impl;

import museum.dao.PostDao;
import museum.dto.post.PostDto;
import museum.entity.Post;
import museum.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

  @Autowired private PostDao postDao;

  @Transactional
  @Override
  public void save(PostDto postDto) {
    Post post = postDtoToPost(postDto);
    postDao.save(post);
  }

  @Transactional
  @Override
  public Post findById(Long id) {
    Post post = postDao.findById(id);
    return post;
  }

  @Override
  public List<Post> findAll() {
    List<Post> posts = postDao.findAll();
    return posts;
  }

  private Post postDtoToPost(PostDto postDto) {
    Post post = new Post();
    post.setName(postDto.getName());
    return post;
  }
}
