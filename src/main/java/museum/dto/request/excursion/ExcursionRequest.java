package museum.dto.request.excursion;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ExcursionRequest {

    @NotNull
    private LocalDateTime begin;

    @NotNull private LocalDateTime end;

    @NotNull private Double price;

    @NotBlank
    private String workerId;

}
