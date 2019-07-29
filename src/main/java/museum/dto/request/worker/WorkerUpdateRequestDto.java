package museum.dto.request.worker;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class WorkerUpdateRequestDto {

  @NotNull private Long id;

  @NotBlank private String firstName;

  @NotBlank private String secondName;

  @NotNull private Long postId;
}
