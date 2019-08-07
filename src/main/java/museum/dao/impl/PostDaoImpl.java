package museum.dao.impl;

import museum.dao.ElementDaoImpl;
import museum.dao.PostDao;
import museum.entity.Post;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * DAO implementation for Post entity.
 *
 * @author Rostyslav Khasanov
 * @version 1.0
 */
@Repository
public class PostDaoImpl extends ElementDaoImpl<Post> implements PostDao {
  public PostDaoImpl() {
    super(Post.class);
  }

  @PersistenceContext private EntityManager entityManager;

    /**
     * Get post by name.
     *
     * @param name post name.
     * @return Post.
     */
  @Override
  public Post findByName(String name) {
    String strQuery = "select p from Post p where p.name = :name";
    TypedQuery query = entityManager.createQuery(strQuery, Post.class).setParameter("name", name);
    if (query.getResultList().isEmpty()) {
        return null;
    } else {
        Post post = (Post) query.getResultList().get(0);
        return post;
    }
  }
}
