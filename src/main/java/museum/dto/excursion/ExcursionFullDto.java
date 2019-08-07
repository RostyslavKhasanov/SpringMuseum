package museum.dto.excursion;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.dto.worker.WorkerNamesDto;
import museum.entity.Excursion;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

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

  @NotNull @Positive private Long id;

  @NotBlank private String description;

  @NotBlank private String begin;

  @NotBlank private String end;

  @NotNull private Double price;

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
