package museum.dto.exhibit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.entity.Author;
import museum.entity.Exhibit;
import museum.entity.Hall;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExhibitInfoDto {

  private Long id;

  private String name;

  private String material;

  private String technology;

  private Author author;

  private Hall hall;

    public ExhibitInfoDto(Exhibit exhibit) {
        this.id = exhibit.getId();
        this.name = exhibit.getName();
        this.material = exhibit.getMaterial();
        this.technology = exhibit.getTechnology();
        this.author = exhibit.getAuthor();
        this.hall = exhibit.getHall();
    }
}
