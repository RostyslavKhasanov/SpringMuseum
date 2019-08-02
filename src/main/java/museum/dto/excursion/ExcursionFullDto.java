package museum.dto.excursion;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ExcursionFullDto {

  @NotBlank private String description;

  @NotBlank private String begin;

  @NotBlank private String end;

  @NotNull private Double price;

  @NotNull private Long workerId;
}
