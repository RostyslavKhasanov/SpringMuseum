package museum.dto.worker;

import lombok.Getter;
import lombok.Setter;
import museum.entity.Worker;

/**
 * DTO for Worker id, firstName, secondName response.
 *
 * @author Rostyslav Khasanov
 * @version 1.0
 */
@Getter
@Setter
public class WorkerNamesDto {

  private Long id;

  private String firstName;

  private String secondName;

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
