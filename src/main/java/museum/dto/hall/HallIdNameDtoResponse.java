package museum.dto.hall;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.entity.Hall;

@Getter
@Setter
@NoArgsConstructor
public class HallIdNameDtoResponse {

  private Long id;

  private String name;

  public HallIdNameDtoResponse(Hall hall) {
    this.id = hall.getId();
    this.name = hall.getName();
  }
}
