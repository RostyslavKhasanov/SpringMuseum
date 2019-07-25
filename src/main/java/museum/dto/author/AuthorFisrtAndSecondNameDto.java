package museum.dto.author;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import museum.entity.Author;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorFisrtAndSecondNameDto {

    private Long id;

    private String firstName;

    private String secondName;

    public AuthorFisrtAndSecondNameDto(Author author) {
        this.id = author.getId();
        this.firstName = author.getFirstName();
        this.secondName = author.getSecondName();
    }
}
