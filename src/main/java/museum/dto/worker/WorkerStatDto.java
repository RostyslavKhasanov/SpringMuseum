package museum.dto.worker;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

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

  @NotNull @Positive private Long id;

  @NotBlank private String firstName;

  @NotBlank private String secondName;

  @NotNull private int countOfExcursion;

  @NotNull private int countOfHour;
}
