package museum.service;

import museum.dto.exhibit.ExhibitInfoDto;
import museum.dto.hall.request.HallRequest;
import museum.dto.hall.response.HallResponse;
import museum.entity.Hall;

import java.util.List;

public interface HallService {
  HallResponse save(HallRequest hallRequest);

  List<HallResponse> findAll();

  Hall findById(Long id);

  HallResponse update(HallRequest hallRequest);

  void deleteById(Long id);

  List<HallResponse> findByWorkerId(Long id);
}
