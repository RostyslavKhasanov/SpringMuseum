package museum.dto.excursion;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.dto.worker.WorkerFirstSecondNameDtoResponse;
import museum.entity.Excursion;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ExcursionResponse {

    private Long id;

    private String description;

    private LocalDateTime begin;

    private LocalDateTime end;

    private Double price;

    private WorkerFirstSecondNameDtoResponse worker;

    public ExcursionResponse(Excursion excursion) {
        this.id = excursion.getId();
        this.description = excursion.getDescription();
        this.begin = excursion.getBegin();
        this.end = excursion.getEnd();
        this.price = excursion.getPrice();
        this.worker = new WorkerFirstSecondNameDtoResponse(excursion.getWorker());
    }

}
