package museum.dto.excursion;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.entity.Excursion;

@Getter
@Setter
@NoArgsConstructor
public class ExcursionIdNameDto {

    private Long id;

    private String description;

    public ExcursionIdNameDto(Excursion excursion) {
        this.id = excursion.getId();
        this.description = excursion.getDescription();
    }
}
