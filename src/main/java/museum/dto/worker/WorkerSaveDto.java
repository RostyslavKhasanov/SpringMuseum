package museum.dto.worker;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * DTO for worker update request
 *
 * @author Rostyslav Khasanov
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class WorkerSaveDto {

  @Length(min = 1, max = 20)
  @NotBlank
  private String firstName;

  @NotBlank
  @Length(min = 1, max = 20)
  private String secondName;

  @NotNull @Positive private Long postId;
}
