package museum.dto.response.hall;

import lombok.Getter;
import lombok.Setter;
import museum.dto.request.exhibit.ExhibitNameDto;
import museum.entity.Hall;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class HallDtoResponse {

  private Long id;

  private String name;

  //private WorkerDto worker;

  private List<ExhibitNameDto> exhibits;

    public HallDtoResponse(Hall hall) {
        this.id = hall.getId();
        this.name = hall.getName();
        //workerDto
        this.exhibits = hall.getExhibits().stream().map(ExhibitNameDto::new).collect(Collectors.toList());

    }
}
