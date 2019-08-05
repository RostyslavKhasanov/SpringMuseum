package museum.dto.exhibit;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.entity.Exhibit;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
@NoArgsConstructor
public class ExhibitIdInitialsDto {
  @NotNull @Positive private Long id;

  @NotBlank
  @Length(max = 100)
  private String name;

  public ExhibitIdInitialsDto(Exhibit exhibit) {
    this.id = exhibit.getId();
    this.name = exhibit.getName();
  }
}
