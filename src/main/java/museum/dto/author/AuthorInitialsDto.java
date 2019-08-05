package museum.dto.author;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.entity.Author;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorInitialsDto {

  @NotBlank
  @Length(max = 50)
  private String firstName;

  @NotBlank
  @Length(max = 50)
  private String secondName;

  public AuthorInitialsDto(Author author) {
    this.firstName = author.getFirstName();
    this.secondName = author.getSecondName();
  }
}
