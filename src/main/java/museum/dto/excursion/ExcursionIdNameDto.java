package museum.dto.excursion;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.entity.Excursion;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

  @NotNull private Long id;

  @NotBlank private String description;

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
