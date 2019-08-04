package museum.dto.exhibit;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.dto.author.AuthorIdInitialsDto;
import museum.dto.hall.HallIdNameDtoResponse;
import museum.entity.Exhibit;

@Getter
@Setter
@NoArgsConstructor
public class ExhibitFullDto {
  private Long id;

  private String name;

  private String material;

  private String technology;

  private AuthorIdInitialsDto author;

  private HallIdNameDtoResponse hall;

  public ExhibitFullDto(Exhibit exhibit) {
    this.id = exhibit.getId();
    this.name = exhibit.getName();
    this.material = exhibit.getMaterial();
    this.technology = exhibit.getTechnology();
    this.author = new AuthorIdInitialsDto(exhibit.getAuthor());
    this.hall = new HallIdNameDtoResponse(exhibit.getHall());
  }
}
