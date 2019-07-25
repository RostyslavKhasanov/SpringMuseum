package museum.dto.excursion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.dto.worker.WorkerResponse;
import museum.entity.Excursion;
import museum.entity.Worker;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExcursionResponse {

    private LocalDateTime begin;

    private LocalDateTime end;

    private Double price;

    private String workerFirstName;

    private String workerSecondName;

    public ExcursionResponse(Excursion excursion) {
        this.begin = excursion.getBegin();
        this.end = excursion.getEnd();
        this.price = excursion.getPrice();
        this.workerFirstName = excursion.getWorker().getFirstName();
        this.workerSecondName = excursion.getWorker().getSecondName();
    }
}
