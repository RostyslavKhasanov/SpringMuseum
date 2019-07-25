package museum.dto.exhibit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.entity.Exhibit;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExhibitNameDto {

  @NotNull private Long id;

  @NotBlank private String name;

  public ExhibitNameDto(Exhibit exhibit) {
    this.id = exhibit.getId();
    this.name = exhibit.getName();
  }
}
