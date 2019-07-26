package museum.dto.hall.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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

  private String workerFirstName;

  private String workerSecondName;

  private List<Exhibit> exhibits;

  public HallResponse(Hall hall) {
    this.id = hall.getId();
    this.name = hall.getName();
    this.workerFirstName = hall.getWorker().getFirstName();
    this.workerSecondName = hall.getWorker().getSecondName();
    if (hall.getExhibits() != null) {
      this.exhibits = hall.getExhibits();
    }
  }
}
