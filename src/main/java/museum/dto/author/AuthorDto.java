package museum.dto.author;

import lombok.Getter;
import lombok.Setter;
import museum.entity.Author;
import museum.entity.Exhibit;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class AuthorDto {

  private Long id;

  private String firstName;

  private String secondName;

  private List<Exhibit> exhibits = new ArrayList<Exhibit>();

  public AuthorDto(Author author) {
    this.id = author.getId();
    this.firstName = author.getFirstName();
    this.secondName = author.getSecondName();
    this.exhibits = author.getExhibits();
  }
}
