package museum.dto.excursion;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.entity.Excursion;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * DTO for Excursion id, description.
 *
 * @author Kateryna Horokh
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class ExcursionIdNameDto {

  @NotNull @Positive private Long id;

  @NotBlank
  @Length(min = 6, max = 30)
  private String description;

  /**
   * Constructor for class.
   *
   * @param excursion object of post.
   */
  public ExcursionIdNameDto(Excursion excursion) {
    this.id = excursion.getId();
    this.description = excursion.getDescription();
  }
}
