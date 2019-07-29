package museum.dto.request.excursion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.entity.Excursion;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExcursionSaveDtoRequest {
  @NotNull private LocalDateTime begin;

  @NotNull private LocalDateTime end;

  @NotNull private Double price;

  @NotNull private Long workerId;

  public ExcursionSaveDtoRequest(Excursion excursion) {
    this.begin = excursion.getBegin();
    this.end = excursion.getEnd();
    this.price = excursion.getPrice();
    this.workerId = excursion.getWorker().getId();
  }
}
