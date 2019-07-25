package museum.dto.worker;

import lombok.Getter;
import lombok.Setter;
import museum.entity.Excursion;
import museum.entity.Hall;
import museum.entity.Worker;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class WorkerDto {

  @NotNull private Long id;

  @NotBlank private String firstName;

  @NotBlank private String secondName;

  @NotNull private Long postId;

  private List<Hall> halls;
  private List<Excursion> excursions;

  public WorkerDto(Worker worker) {
    this.id = worker.getId();
    this.firstName = worker.getFirstName();
    this.secondName = worker.getSecondName();
    this.postId = worker.getPost().getId();
    this.halls = worker.getHalls();
    this.excursions = worker.getExcursions();
  }
}
