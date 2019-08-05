package museum.dto.author;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.dto.exhibit.ExhibitIdInitialsDto;
import museum.entity.Author;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class AuthorFullDto {

  @NotNull @Positive private Long id;

  @NotBlank
  @Length(max = 50)
  private String firstName;

  @NotBlank
  @Length(max = 50)
  private String secondName;

  private List<ExhibitIdInitialsDto> exhibits;

  public AuthorFullDto(Author author) {
    this.id = author.getId();
    this.firstName = author.getFirstName();
    this.secondName = author.getSecondName();
    this.exhibits =
        author.getExhibits().stream().map(ExhibitIdInitialsDto::new).collect(Collectors.toList());
  }
}
