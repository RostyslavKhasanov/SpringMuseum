package museum.dto.excursion;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.entity.Excursion;

import java.time.LocalDateTime;

/**
 * DTO for Excursion begin and end date.
 *
 * @author Kateryna Horokh
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class ExcursionBeginEndDtoResponse {

  private Long id;

  private LocalDateTime begin;

  private LocalDateTime end;

  /**
   * Constructor for class.
   *
   * @param excursion object of post.
   */
  public ExcursionBeginEndDtoResponse(Excursion excursion) {
    this.id = excursion.getId();
    this.begin = excursion.getBegin();
    this.end = excursion.getEnd();
  }
}
