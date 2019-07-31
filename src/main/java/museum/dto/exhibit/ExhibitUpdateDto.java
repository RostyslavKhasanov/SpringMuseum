package museum.dto.exhibit;

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
public class ExhibitUpdateDto {

  @NotNull private Long id;
  @NotBlank private String name;
  @NotBlank private String material;
  @NotBlank private String technology;

  @NotNull private Long authorId;
  @NotNull private Long hallId;
}
