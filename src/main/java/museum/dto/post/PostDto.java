package museum.dto.post;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.entity.Post;
import museum.entity.Worker;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

/**
 * DTO for Post id, name, workers response
 *
 * @author Rostyslav Khasanov
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class PostDto {

  @NotNull @Positive private Long id;

  @NotBlank
  @Length(min = 2, max = 20)
  private String name;

  private List<Worker> workers;

  public PostDto(Post post) {
    this.id = post.getId();
    this.name = post.getName();
    this.workers = post.getWorkers();
  }
}
