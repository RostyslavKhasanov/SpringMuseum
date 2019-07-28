package museum.dto.request.author;

import lombok.Getter;
import lombok.Setter;
import museum.entity.Author;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AuthorUpdateDtoRequest {

  @NotNull private Long id;
  @NotBlank private String firstName;
  @NotBlank private String secondName;

  public AuthorUpdateDtoRequest(Author author) {
    this.id = author.getId();
    this.firstName = author.getFirstName();
    this.secondName = author.getSecondName();
  }
}
