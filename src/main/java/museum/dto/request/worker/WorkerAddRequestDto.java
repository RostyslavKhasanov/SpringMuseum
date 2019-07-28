package museum.dto.request.worker;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class WorkerAddRequestDto {

  @NotBlank private String firstName;

  @NotBlank private String secondName;

  @NotNull private Long postId;
}
