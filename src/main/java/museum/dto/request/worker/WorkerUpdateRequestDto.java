package museum.dto.request.worker;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * DTO for worker update request
 *
 * @author Rostyslav Khasanov
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class WorkerUpdateRequestDto {

  @NotNull private Long id;

  @NotBlank private String firstName;

  @NotBlank private String secondName;

  @NotNull private Long postId;
}
