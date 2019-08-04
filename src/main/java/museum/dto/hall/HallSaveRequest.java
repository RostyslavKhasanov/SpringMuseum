package museum.dto.hall;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.entity.Hall;

/**
 * DTO for Hall saving.
 *
 * @author Kateryna Horokh
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class HallSaveRequest {

  private Long id;

  private String name;

  private Long workerId;

  /**
   * Constructor for class.
   *
   * @param hall object of post.
   */
  public HallSaveRequest(Hall hall) {
    this.id = hall.getId();
    this.name = hall.getName();
    this.workerId = hall.getWorker().getId();
  }
}
