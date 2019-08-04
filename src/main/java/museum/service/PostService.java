package museum.service;

import museum.dto.post.PostDto;
import museum.dto.post.PostSaveDto;
import museum.entity.Post;
import museum.exception.BadIdException;
import museum.exception.EntityConstraintException;

import java.util.List;

/**
 * Service interface for Post entity.
 *
 * @author Rostyslav Khasanov
 * @version 1.0
 */
public interface PostService {

  /**
   * Save post.
   *
   * @param postSaveDto request dto
   */
  void save(PostSaveDto postSaveDto);

  /**
   * Get post by id.
   *
   * @return PostDto by id.
   */
  PostDto findById(Long id);

  /**
   * Get all posts.
   *
   * @return List of all post.
   */
  List<PostDto> findAll();

  /**
   * Get one post by id.
   *
   * @param id post id.
   * @return Post by id.
   */
  Post getOneById(Long id);

  /**
   * Delete post by id.
   *
   * @param id post id
   */
  void delete(Long id) throws EntityConstraintException;
}
