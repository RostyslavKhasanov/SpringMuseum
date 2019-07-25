package museum.dto.excursion;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExcursionRequest {

  @NotNull private LocalDateTime begin;

  @NotNull private LocalDateTime end;

  @NotNull private Double price;

  @NotBlank private String workerId;
}
