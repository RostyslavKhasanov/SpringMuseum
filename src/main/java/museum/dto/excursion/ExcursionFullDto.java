package museum.dto.excursion;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.dto.worker.WorkerNamesDto;
import museum.entity.Excursion;

/**
 * DTO for Excursion response.
 *
 * @author Kateryna Horokh
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class ExcursionFullDto {

  private Long id;

  private String description;

  private String begin;

  private String end;

  private Double price;

  private WorkerNamesDto worker;

  /**
   * Constructor for class.
   *
   * @param excursion object of post.
   */
  public ExcursionFullDto(Excursion excursion) {
    this.id = excursion.getId();
    this.description = excursion.getDescription();
    this.begin = excursion.getBegin().toString();
    this.end = excursion.getEnd().toString();
    this.price = excursion.getPrice();
    this.worker = new WorkerNamesDto(excursion.getWorker());
  }
}
