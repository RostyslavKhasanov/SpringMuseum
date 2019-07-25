package museum.dto.author;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.entity.Author;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorFirstAndSecondNameDto {

  @NotNull private Long id;

  @NotBlank private String firstName;

  @NotBlank private String secondName;

  public AuthorFirstAndSecondNameDto(Author author) {
    this.id = author.getId();
    this.firstName = author.getFirstName();
    this.secondName = author.getSecondName();
  }
}
