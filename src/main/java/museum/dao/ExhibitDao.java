package museum.dao;

import museum.dto.exhibit.ExhibitInfoDto;
import museum.entity.Exhibit;

import java.util.List;

public interface ExhibitDao extends ElementDao<Exhibit> {

    List<ExhibitInfoDto> findExhibitsByHall(Long hallId);

}
