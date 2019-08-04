package museum.dto.post;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.entity.Worker;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

  @NotBlank private String name;

  private List<Worker> workers;
}
