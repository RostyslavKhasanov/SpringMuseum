package museum.dto.worker;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.entity.Worker;

import javax.validation.constraints.NotBlank;

/**
 * DTO for Worker id, firstName, secondName response.
 *
 * @author Rostyslav Khasanov
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class WorkerNamesDto {

  private Long id;

  @NotBlank private String firstName;

  @NotBlank private String secondName;

  /**
   * Constructor for class.
   *
   * @param worker object of post.
   */
  public WorkerNamesDto(Worker worker) {
    this.id = worker.getId();
    this.firstName = worker.getFirstName();
    this.secondName = worker.getSecondName();
  }
}
