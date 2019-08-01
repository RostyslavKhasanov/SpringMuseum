package museum.dto.author;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.dto.exhibit.ExhibitIdInitialsDto;
import museum.entity.Author;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class AuthorFullDto {

  private Long id;

  private String firstName;

  private String secondName;

  private List<ExhibitIdInitialsDto> exhibits;

}
