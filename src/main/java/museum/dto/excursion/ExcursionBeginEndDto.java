package museum.dto.excursion;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.entity.Excursion;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
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
public class ExcursionBeginEndDto {

  @NotNull @Positive private Long id;

  @NotNull private LocalDateTime begin;

  @NotNull private LocalDateTime end;

  /**
   * Constructor for class.
   *
   * @param excursion object of post.
   */
  public ExcursionBeginEndDto(Excursion excursion) {
    this.id = excursion.getId();
    this.begin = excursion.getBegin();
    this.end = excursion.getEnd();
  }
}
