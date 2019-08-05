package museum.dto.worker;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.dto.excursion.ExcursionBeginEndDtoResponse;
import museum.dto.hall.HallIdNameDtoResponse;
import museum.entity.Post;
import museum.entity.Worker;

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

  @NotBlank private String firstName;

  @NotBlank private String secondName;

  private Post post;

  private List<HallIdNameDtoResponse> halls;
  private List<ExcursionBeginEndDtoResponse> excursions;

  public WorkerDto(Worker worker) {
    this.id = worker.getId();
    this.firstName = worker.getFirstName();
    this.secondName = worker.getSecondName();
    this.post = worker.getPost();
    this.halls =
        worker.getHalls().stream().map(HallIdNameDtoResponse::new).collect(Collectors.toList());
    this.excursions =
        worker.getExcursions().stream()
            .map(ExcursionBeginEndDtoResponse::new)
            .collect(Collectors.toList());
    ;
  }
}
