package museum.service.impl;

import lombok.AllArgsConstructor;
import museum.dao.PostDao;
import museum.dto.post.PostDto;
import museum.dto.post.PostSaveDto;
import museum.entity.Post;
import museum.exception.BadIdException;
import museum.exception.PostExistException;
import museum.service.PostService;
import museum.utils.ObjectMapperUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

  private ObjectMapperUtils modelMapper;

  /**
   * Save post.
   *
   * @param postSaveDto request dto
   */
  @Transactional
  @Override
  public void save(PostSaveDto postSaveDto) {
    if (postDao.findByName(postSaveDto.getName()) == null) {
      postDao.save(modelMapper.map(postSaveDto, Post.class));
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
  public PostDto findById(Long id) {
    return modelMapper.map(postDao.findById(id), PostDto.class);
  }

  /**
   * Get all posts.
   *
   * @return List of all post.
   */
  @Transactional
  @Override
  public List<PostDto> findAll() {
    return modelMapper.mapAll(postDao.findAll(), PostDto.class);
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
  public void delete(Long id) {
    Boolean isDeleted = postDao.deleteById(id);
    if (!isDeleted) {
      throw new BadIdException("Post with entered id doesn't exist");
    }
  }
}
