package museum.dao;

import museum.dto.exhibit.ExhibitMaterialStatDto;
import museum.dto.exhibit.ExhibitTechnologyStat;
import museum.entity.Exhibit;

import java.util.List;

public interface ExhibitDao extends ElementDao<Exhibit> {
    List<ExhibitMaterialStatDto> getMaterialStat();

    List<ExhibitTechnologyStat> getTechnologyStat();
}
