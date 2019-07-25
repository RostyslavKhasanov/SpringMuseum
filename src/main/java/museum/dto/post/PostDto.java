package museum.dto.post;

import lombok.Getter;
import lombok.Setter;
import museum.entity.Post;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PostDto {

  @NotNull private Long id;

  @NotBlank private String name;

  public PostDto(Post post) {
    this.id = post.getId();
    this.name = post.getName();
  }
}
