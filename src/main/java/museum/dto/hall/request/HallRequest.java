package museum.dto.hall.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HallRequest {

  @NotBlank private String name;

  private Long workerId;

  @NotNull private Long exhibitId;

}
