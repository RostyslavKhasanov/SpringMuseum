package museum.dto.worker;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * DTO for Worker statistic response.
 *
 * @author Rostyslav Khasanov
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class WorkerStatDto {

  private Long id;

  @NotBlank private String firstName;

  @NotBlank private String secondName;

  private int countOfExcursion;

  private int countOfHour;
}
