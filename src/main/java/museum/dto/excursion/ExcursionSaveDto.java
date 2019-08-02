package museum.dto.excursion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.entity.Excursion;
import museum.utils.ConverterStringToLocalDateTime;

import javax.persistence.Convert;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExcursionSaveDto {

  @NotBlank private String description;

  @NotBlank private String begin;

  @NotBlank private String end;

  @NotNull private Double price;

  @NotNull private Long workerId;

  public ExcursionSaveDto(Excursion excursion) {
    this.description = excursion.getDescription();
    this.begin = excursion.getBegin().toString();
    this.end = excursion.getEnd().toString();
    this.price = excursion.getPrice();
    this.workerId = excursion.getWorker().getId();
  }

}
