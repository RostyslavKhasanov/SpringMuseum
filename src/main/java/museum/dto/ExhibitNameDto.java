package museum.dto;

import museum.entity.Exhibit;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExhibitNameDto {

  private Long id;

  private String name;

  public ExhibitNameDto(Exhibit exhibit) {
    this.id = exhibit.getId();
    this.name = exhibit.getName();
  }
}
