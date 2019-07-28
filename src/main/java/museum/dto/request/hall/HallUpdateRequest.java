package museum.dto.request.hall;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class HallUpdateRequest {

  @NotNull private Long id;

  private String name;

  private Long workerId;
}
