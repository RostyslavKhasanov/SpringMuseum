package museum.dto.excursion;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.entity.Excursion;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * DTO for Excursion request for updating.
 *
 * @author Kateryna Horokh
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class ExcursionUpdateDto {

  @NotNull @Positive private Long id;

  @NotBlank
  @Length(min = 6, max = 30)
  private String description;

  @NotBlank private String begin;

  @NotBlank private String end;

  @NotNull private Double price;

  @NotNull private Long workerId;

  /**
   * Constructor for class.
   *
   * @param excursion object of post.
   */
  public ExcursionUpdateDto(Excursion excursion) {
    this.id = excursion.getId();
    this.description = excursion.getDescription();
    this.begin = excursion.getBegin().toString();
    this.end = excursion.getEnd().toString();
    this.price = excursion.getPrice();
    this.workerId = excursion.getWorker().getId();
  }
}
