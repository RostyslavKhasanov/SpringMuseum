package museum.dto.post;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.entity.Post;
import museum.entity.Worker;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

  @NotNull private Long id;

  @NotBlank private String name;

  private List<Worker> workers;

  public PostDto(Post post) {
    this.id = post.getId();
    this.name = post.getName();
  }
}
