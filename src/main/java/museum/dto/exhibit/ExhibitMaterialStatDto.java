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
public class ExhibitMaterialStatDto {
  @NotBlank
  private String materialName;
  @NotNull
  private Long materialCount;
}
