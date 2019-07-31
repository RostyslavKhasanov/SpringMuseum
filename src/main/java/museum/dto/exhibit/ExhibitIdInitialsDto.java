package museum.dto.exhibit;

import lombok.Getter;
import lombok.Setter;
import museum.entity.Exhibit;

@Getter
@Setter
public class ExhibitIdInitialsDto {
    private Long id;

    private String name;

    public ExhibitIdInitialsDto(Exhibit exhibit) {
        this.id = exhibit.getId();
        this.name = exhibit.getName();
    }
}
