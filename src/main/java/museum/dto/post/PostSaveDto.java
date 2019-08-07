package museum.dto.post;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.entity.Worker;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * DTO for save post.
 *
 * @author Rostyslav Khasanov
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class PostSaveDto {

  @Length(min = 2, max = 20)
  @NotBlank
  private String name;

  private List<Worker> workers;
}
