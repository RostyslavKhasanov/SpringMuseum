package museum.dto.author;

import lombok.Getter;
import lombok.Setter;
import museum.entity.Author;
import museum.entity.Exhibit;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class AuthorDto {

  @NotNull private Long id;
  @NotBlank private String firstName;
  @NotBlank private String secondName;

  private List<Exhibit> exhibits;

  public AuthorDto(Author author) {
    this.id = author.getId();
    this.firstName = author.getFirstName();
    this.secondName = author.getSecondName();
    this.exhibits = author.getExhibits();
  }
}
