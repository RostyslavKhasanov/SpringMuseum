package museum.service.impl;

import museum.dao.ExhibitDao;
import museum.dto.exhibit.ExhibitInfoDto;
import museum.service.ExhibitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExhibitServiceImpl implements ExhibitService {

  @Autowired private ExhibitDao exhibit;

  @Override
  public List<ExhibitInfoDto> findByHallId(Long id) {
    return exhibit.findExhibitsByHall(id);
  }
}
