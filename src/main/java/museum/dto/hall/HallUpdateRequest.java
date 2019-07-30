package museum.dto.hall;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class HallUpdateRequest {

  private Long id;

  private String name;

  private Long workerId;
}
