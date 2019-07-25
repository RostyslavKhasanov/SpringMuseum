package museum.service;

import museum.dao.impl.AuthorDaoImpl;
import museum.dto.author.AuthorFisrtAndSecondNameDto;

import java.util.List;

public interface AuthorService {
  void save(AuthorFisrtAndSecondNameDto dto);

  List<AuthorFisrtAndSecondNameDto> findAll();

  AuthorDaoImpl findById(Long id);

  void update(AuthorFisrtAndSecondNameDto dto);

  void deleteById(Long id);
}
