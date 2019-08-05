package museum.dto.exhibit;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.dto.author.AuthorIdInitialsDto;
import museum.dto.hall.HallIdNameDto;
import museum.entity.Exhibit;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@NoArgsConstructor
public class ExhibitFullDto {
  @NotNull @Positive private Long id;

  @NotBlank
  @Length(max = 100)
  private String name;

  @NotBlank
  @Length(max = 50)
  private String material;

  @NotBlank
  @Length(max = 50)
  private String technology;

  @NotNull private AuthorIdInitialsDto author;

  @NotNull private HallIdNameDto hall;

  public ExhibitFullDto(Exhibit exhibit) {
    this.id = exhibit.getId();
    this.name = exhibit.getName();
    this.material = exhibit.getMaterial();
    this.technology = exhibit.getTechnology();
    this.author = new AuthorIdInitialsDto(exhibit.getAuthor());
    this.hall = new HallIdNameDto(exhibit.getHall());
  }
}
