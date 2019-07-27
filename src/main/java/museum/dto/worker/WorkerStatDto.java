package museum.dto.worker;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class WorkerStatDto {

  @NotNull private Long id;

  @NotBlank private String firstName;

  @NotBlank private String secondName;

  private int countOfExcursion;

  private int countOfHour;
}
