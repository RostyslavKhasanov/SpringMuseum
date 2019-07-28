package museum.dto.response.author;

import lombok.Getter;
import lombok.Setter;
import museum.dto.request.exhibit.ExhibitNameDto;
import museum.entity.Author;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class AuthorDtoResponse {

  private Long id;

  private String firstName;

  private String secondName;

  private List<ExhibitNameDto> exhibits;

  public AuthorDtoResponse(Author author) {
    this.id = author.getId();
    this.firstName = author.getFirstName();
    this.secondName = author.getSecondName();
    this.exhibits =
        author.getExhibits().stream().map(ExhibitNameDto::new).collect(Collectors.toList());
  }
}
