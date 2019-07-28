package museum.dto.request.exhibit;

import lombok.Getter;
import lombok.Setter;
import museum.entity.Exhibit;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ExhibitDto {

  @NotNull private Long id;

  @NotBlank private String name;
  @NotBlank private String material;
  @NotBlank private String technology;

  @NotNull private Long authorId;
  @NotNull private Long hall_id;

  public ExhibitDto(Exhibit exhibit) {
    this.id = exhibit.getId();
    this.name = exhibit.getName();
    this.material = exhibit.getMaterial();
    this.technology = exhibit.getTechnology();
    this.authorId = exhibit.getAuthor().getId();
    this.hall_id = exhibit.getHall().getId();
  }
}
