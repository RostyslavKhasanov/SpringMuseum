package museum.dto.response.worker;

import lombok.Getter;
import lombok.Setter;
import museum.entity.Worker;

@Getter
@Setter
public class WorkerResponse {

  private Long id;

  private String firstName;

  private String secondName;

  public WorkerResponse(Worker worker) {
    this.id = worker.getId();
    this.firstName = worker.getFirstName();
    this.secondName = worker.getSecondName();
  }
}
