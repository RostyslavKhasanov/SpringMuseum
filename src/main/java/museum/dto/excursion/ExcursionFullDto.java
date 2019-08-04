package museum.dto.excursion;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.dto.worker.WorkerIdFirstSecondNameDtoResponse;
import museum.entity.Excursion;

@Getter
@Setter
@NoArgsConstructor
public class ExcursionFullDto {

  private Long id;

  private String description;

  private String begin;

  private String end;

  private Double price;

  private WorkerIdFirstSecondNameDtoResponse worker;

  public ExcursionFullDto(Excursion excursion) {
    this.id = excursion.getId();
    this.description = excursion.getDescription();
    this.begin = excursion.getBegin().toString();
    this.end = excursion.getEnd().toString();
    this.price = excursion.getPrice();
    this.worker = new WorkerIdFirstSecondNameDtoResponse(excursion.getWorker());
  }
}
