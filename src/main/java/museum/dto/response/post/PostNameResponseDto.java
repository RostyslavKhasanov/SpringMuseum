package museum.dto.response.post;

import lombok.Getter;
import lombok.Setter;
import museum.entity.Post;

@Getter
@Setter
public class PostNameResponseDto {

  private String name;

  public PostNameResponseDto(Post post) {
    this.name = post.getName();
  }
}
