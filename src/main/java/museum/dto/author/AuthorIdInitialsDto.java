package museum.dto.author;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.entity.Author;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@NoArgsConstructor
public class AuthorIdInitialsDto {

  @NotNull
  @Positive
  private Long id;

  @NotBlank
  @Length(max = 50)
  private String firstName;

  @Length(max = 50)
  @NotBlank
  private String secondName;

  public AuthorIdInitialsDto(Author author) {
    this.id = author.getId();
    this.firstName = author.getFirstName();
    this.secondName = author.getSecondName();
  }
}
