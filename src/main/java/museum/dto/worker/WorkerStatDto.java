package museum.dto.worker;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO for Worker statistic response.
 *
 * @author Rostyslav Khasanov
 * @version 1.0
 */
@Getter
@Setter
public class WorkerStatDto {

  private Long id;

  private String firstName;

  private String secondName;

  private int countOfExcursion;

  private int countOfHour;
}
