package museum.dto.post;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.entity.Worker;

import javax.validation.constraints.NotBlank;
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

  private Long id;

  @NotBlank private String name;

  private List<Worker> workers;
}
