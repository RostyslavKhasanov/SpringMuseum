package museum.dto.exhibit;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.dto.author.AuthorIdInitialsDto;
import museum.dto.hall.HallIdNameDtoResponse;

@Getter
@Setter
@NoArgsConstructor
public class ExhibitFullDto {
  private Long id;

  private String name;

  private String material;

  private String technology;

  private AuthorIdInitialsDto author;

  private HallIdNameDtoResponse hall;
}
