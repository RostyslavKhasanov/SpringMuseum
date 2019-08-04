package museum.service.impl;

import javafx.geometry.Pos;
import lombok.AllArgsConstructor;
import museum.dao.PostDao;
import museum.dto.post.PostDto;
import museum.dto.post.PostSaveDto;
import museum.entity.Post;
import museum.exception.BadIdException;
import museum.exception.EntityConstraintException;
import museum.exception.PostExistException;
import museum.service.PostService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service implementation for Post entity.
 *
 * @author Rostyslav Khasanov
 * @version 1.0
 */
@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {

  private PostDao postDao;

  /**
   * Save post.
   *
   * @param postSaveDto request dto
   */
  @Transactional
  @Override
  public void save(PostSaveDto postSaveDto) {
    if (postDao.findByName(postSaveDto.getName()) == null) {
      postDao.save(Post.builder().name(postSaveDto.getName()).build());
    } else {
      throw new PostExistException("Post is already exist!  ");
    }
  }

  /**
   * Get post by id.
   *
   * @return PostResponseDto by id.
   */
  @Transactional
  @Override
  public PostDto findById(Long id) throws BadIdException {
    PostDto postDto = new PostDto(postDao.findById(id));
    if (postDto == null) {
      throw new BadIdException("Worker with id " + id + " doesn't exist!");
    } else {
      return postDto;
    }
  }

  /**
   * Get all posts.
   *
   * @return List of all post.
   */
  @Transactional
  @Override
  public List<PostDto> findAll() {
    List<Post> posts = postDao.findAll();
    return posts.stream().map(PostDto::new).collect(Collectors.toList());
  }

  /**
   * Get one post by id.
   *
   * @param id post id.
   * @return Post by id.
   */
  @Transactional
  @Override
  public Post getOneById(Long id) {
    Post post = postDao.findById(id);
    if (post == null) {
      throw new BadIdException("Post with id " + id + " doesn't exist");
    }
    return post;
  }

  /**
   * Delete post by id.
   *
   * @param id post id
   */
  @Transactional
  @Override
  public void delete(Long id) throws EntityConstraintException {
    Post post = postDao.findById(id);
    if (post.getWorkers().size() != 0) {
      throw new EntityConstraintException(
          "You can't delete this post, because exist workers with this post!");
    } else {
      postDao.deleteById(id);
    }
  }
}
