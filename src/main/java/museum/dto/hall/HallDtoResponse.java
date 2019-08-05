package museum.dto.hall;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.dto.exhibit.ExhibitIdInitialsDto;
import museum.dto.worker.WorkerNamesDto;
import museum.entity.Hall;

import java.util.List;
import java.util.stream.Collectors;

/**
 * DTO for Hall response.
 *
 * @author Kateryna Horokh
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class HallDtoResponse {

  private Long id;

  private String name;

  private WorkerNamesDto worker;

  private List<ExhibitIdInitialsDto> exhibits;

  /**
   * Constructor for class.
   *
   * @param hall object of post.
   */
  public HallDtoResponse(Hall hall) {
    this.id = hall.getId();
    this.name = hall.getName();
    this.worker = new WorkerNamesDto(hall.getWorker());
    this.exhibits =
        hall.getExhibits().stream().map(ExhibitIdInitialsDto::new).collect(Collectors.toList());
  }
}
