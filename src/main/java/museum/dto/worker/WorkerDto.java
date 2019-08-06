package museum.dto.worker;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.dto.excursion.ExcursionBeginEndDto;
import museum.dto.hall.HallIdNameDto;
import museum.entity.Post;
import museum.entity.Worker;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.stream.Collectors;

/**
 * DTO for Worker response.
 *
 * @author Rostyslav Khasanov
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class WorkerDto {

  private Long id;

  @NotBlank
  @Length(min = 1, max = 20)
  private String firstName;

  @NotBlank
  @Length(min = 1, max = 20)
  private String secondName;

  private Post post;

  private List<HallIdNameDto> halls;
  private List<ExcursionBeginEndDto> excursions;

  public WorkerDto(Worker worker) {
    this.id = worker.getId();
    this.firstName = worker.getFirstName();
    this.secondName = worker.getSecondName();
    this.post = worker.getPost();
    this.halls =
        worker.getHalls().stream().map(HallIdNameDto::new).collect(Collectors.toList());
    this.excursions =
        worker.getExcursions().stream()
            .map(ExcursionBeginEndDto::new)
            .collect(Collectors.toList());
    ;
  }
}
