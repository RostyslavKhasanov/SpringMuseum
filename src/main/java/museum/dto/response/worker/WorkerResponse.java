package museum.dto.response.worker;

import museum.entity.Worker;

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
