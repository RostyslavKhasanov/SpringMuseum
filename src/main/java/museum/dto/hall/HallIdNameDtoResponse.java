package museum.dto.hall;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.entity.Hall;

/**
 * DTO for Hall id, name.
 *
 * @author Kateryna Horokh
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class HallIdNameDtoResponse {

  private Long id;

  private String name;

  /**
   * Constructor for class.
   *
   * @param hall object of post.
   */
  public HallIdNameDtoResponse(Hall hall) {
    this.id = hall.getId();
    this.name = hall.getName();
  }
}
