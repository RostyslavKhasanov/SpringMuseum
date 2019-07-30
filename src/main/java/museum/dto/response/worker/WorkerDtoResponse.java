package museum.dto.response.worker;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.entity.Excursion;
import museum.entity.Hall;
import museum.entity.Worker;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class WorkerDtoResponse {

  private Long id;

  private String firstName;

  private String secondName;

  private Long postId;

  private List<Hall> halls;

  private List<Excursion> excursions;

  public WorkerDtoResponse(Worker worker) {
    this.id = worker.getId();
    this.firstName = worker.getFirstName();
    this.secondName = worker.getSecondName();
    this.postId = worker.getPost().getId();
    this.halls = worker.getHalls();
    this.excursions = worker.getExcursions();
  }
}
