package museum.dto.hall;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.dto.exhibit.ExhibitIdNameDtoResponse;
import museum.dto.worker.WorkerNamesDto;
import museum.entity.Hall;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class HallDtoResponse {

  private Long id;

  private String name;

  private WorkerNamesDto worker;

  private List<ExhibitIdNameDtoResponse> exhibits;

  public HallDtoResponse(Hall hall) {
    this.id = hall.getId();
    this.name = hall.getName();
    this.worker = new WorkerNamesDto(hall.getWorker());
    this.exhibits =
        hall.getExhibits().stream().map(ExhibitIdNameDtoResponse::new).collect(Collectors.toList());
  }
}
