package museum.dto.excursion;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.entity.Excursion;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class ExcursionUpdateDto {

  @NotNull private Long id;

  @NotBlank private String description;

  @NotBlank private String begin;

  @NotBlank private String end;

  @NotNull private Double price;

  @NotNull private Long workerId;

  public ExcursionUpdateDto(Excursion excursion) {
    this.id = excursion.getId();
    this.description = excursion.getDescription();
    this.begin = excursion.getBegin().toString();
    this.end = excursion.getEnd().toString();
    this.price = excursion.getPrice();
    this.workerId = excursion.getWorker().getId();
  }
}
