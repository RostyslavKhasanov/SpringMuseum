package museum.service;

import museum.dto.post.PostDto;
import museum.dto.post.PostSaveDto;
import museum.entity.Post;
import museum.exception.BadIdException;
import museum.exception.EntityConstraintException;
import museum.exception.PostExistException;

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
   * @throws PostExistException if post already exist.
   * @param postSaveDto request dto
   */
  void save(PostSaveDto postSaveDto) throws PostExistException;

  /**
   * Get post by id.
   *
   * @param id post id.
   * @throws BadIdException if post with entered id doesn't exist.
   * @return PostDto by id.
   */
  PostDto findById(Long id) throws BadIdException;

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
   * @throws BadIdException if post with entered id doesn't exist.
   * @return Post by id.
   */
  Post getOneById(Long id) throws BadIdException;

  /**
   * Delete post by id.
   *
   * @throws EntityConstraintException if exist workers with this post.
   * @param id post id
   */
  void delete(Long id) throws EntityConstraintException;
}
