package museum.dto.response.hall;

import lombok.Getter;
import lombok.Setter;
import museum.dto.response.exhibit.ExhibitIdNameDtoResponse;
import museum.entity.Hall;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class HallDtoResponse {

  private Long id;

  private String name;

  // private WorkerDto worker;

  private List<ExhibitIdNameDtoResponse> exhibits;

  public HallDtoResponse(Hall hall) {
    this.id = hall.getId();
    this.name = hall.getName();
    // workerDto
    this.exhibits =
        hall.getExhibits().stream().map(ExhibitIdNameDtoResponse::new).collect(Collectors.toList());
  }
}
