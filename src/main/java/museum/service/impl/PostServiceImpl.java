package museum.service.impl;

import javafx.geometry.Pos;
import museum.dao.PostDao;
import museum.dto.post.PostDto;
import museum.entity.Post;
import museum.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    @Override
    public void save(PostDto postDto) {
        Post post = postDtoToPost(postDto);
        postDao.save(post);
    }

    private Post postDtoToPost(PostDto postDto) {
        Post post = new Post();
        post.setName(postDto.getName());
        return post;
    }
}
