package museum.dto.hall;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.entity.Hall;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

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

  @NotNull @Positive private Long id;

  @NotBlank
  @Length(min = 3, max = 30)
  private String name;

  @NotNull private Long workerId;

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
