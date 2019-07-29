package museum.dto.response.post;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.entity.Post;

@Getter
@Setter
@NoArgsConstructor
public class PostResponseDto {

    private Long id;

    private String name;

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.name = post.getName();
    }

}
