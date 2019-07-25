package museum.service;

import museum.dto.exhibit.ExhibitInfoDto;

import java.util.List;

public interface ExhibitService {

    List<ExhibitInfoDto> findByHallId(Long id);
}
