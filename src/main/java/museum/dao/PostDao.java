package museum.dao;

import javafx.geometry.Pos;
import museum.entity.Post;

/**
 * DAO interface for Post entity.
 *
 * @author Rostyslav Khasanov
 * @version 1.0
 */
public interface PostDao extends ElementDao<Post> {

    Post findByName(String name);

}
