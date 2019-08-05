package museum.dto.exhibit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.entity.Exhibit;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Save DTO for Exhibit.
 *
 * @author Nazar Stasyuk
 * @version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExhibitSaveDto {

  @NotBlank
  @Length(max = 100)
  private String name;

  @NotBlank
  @Length(max = 50)
  private String material;

  @NotBlank
  @Length(max = 50)
  private String technology;

  @NotNull private Long authorId;
  @NotNull private Long hallId;

  /**
   * Constructor for class.
   *
   * @param exhibit is Entity that you want to cast to dto.
   */
  public ExhibitSaveDto(Exhibit exhibit) {
    this.name = exhibit.getName();
    this.material = exhibit.getMaterial();
    this.technology = exhibit.getTechnology();
    this.authorId = exhibit.getAuthor().getId();
    this.hallId = exhibit.getHall().getId();
  }
}
