package museum.dto.exhibit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Material statistic DTO for Exhibit.
 *
 * @author Nazar Stasyuk
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExhibitMaterialStatDto {
  @NotBlank private String materialName;
  @NotNull private Long materialCount;
}
