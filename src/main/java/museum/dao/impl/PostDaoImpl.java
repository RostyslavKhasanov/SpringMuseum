package museum.dao.impl;

import museum.dao.ElementDaoImpl;
import museum.dao.PostDao;
import museum.entity.Post;
import org.springframework.stereotype.Repository;


@Repository
public class PostDaoImpl extends ElementDaoImpl<Post> implements PostDao {
    public PostDaoImpl() {
        super(Post.class);
    }
}
