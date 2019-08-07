package museum.dto.worker;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@NoArgsConstructor
public class WorkerEditDto {

  @NotNull @Positive private Long id;

  @Length(min = 1, max = 20)
  @NotBlank
  private String firstName;

  @Length(min = 1, max = 20)
  @NotBlank
  private String secondName;

  @NotNull @Positive private Long postId;
}
