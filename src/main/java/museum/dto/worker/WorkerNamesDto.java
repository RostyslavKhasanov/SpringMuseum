package museum.dto.worker;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.entity.Worker;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

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

  @NotNull @Positive private Long id;

  @NotBlank
  @Length(min = 1, max = 20)
  private String firstName;

  @NotBlank
  @Length(min = 1, max = 20)
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
