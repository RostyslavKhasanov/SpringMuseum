package museum.service;

import museum.dto.author.AuthorFirstAndSecondNameDto;
import museum.entity.Author;

import javax.transaction.Transactional;
import java.util.List;

public interface AuthorService {

  void save(AuthorFirstAndSecondNameDto dto);

  List<AuthorFirstAndSecondNameDto> findAll();

  Author findById(Long id);

  Author update(AuthorFirstAndSecondNameDto dto);

  void deleteById(Long id);
}
