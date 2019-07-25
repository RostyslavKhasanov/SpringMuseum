package museum.dto.hall.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.dto.exhibit.ExhibitInfoDto;
import museum.dto.worker.WorkerResponse;
import museum.entity.Exhibit;
import museum.entity.Hall;
import museum.entity.Worker;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HallResponse {

  private Long id;

  private String name;

  private Worker worker;

  private List<Exhibit> exhibits;

  public HallResponse(Hall hall) {
    this.id = hall.getId();
    this.name = hall.getName();
    this.worker = hall.getWorker();
    if (hall.getExhibits() != null) {
      this.exhibits = hall.getExhibits();
    }
  }
}
