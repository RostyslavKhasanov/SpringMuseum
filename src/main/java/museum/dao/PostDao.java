package museum.dao;

import museum.entity.Post;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class PostDao extends ElementDaoImpl<Post> {

    public PostDao() {
        super(Post.class);
    }
}
