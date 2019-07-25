package museum.service.impl;

import museum.dao.AuthorDao;
import museum.dao.impl.AuthorDaoImpl;
import museum.dto.author.AuthorFisrtAndSecondNameDto;
import museum.entity.Author;
import museum.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

  @Autowired private AuthorDao dao;

  @Override
  public void save(AuthorFisrtAndSecondNameDto dto) {
    Author author = new Author();
    author.setFirstName(dto.getFirstName());
    author.setSecondName(dto.getSecondName());
    dao.save(author);
  }

  @Override
  public List<AuthorFisrtAndSecondNameDto> findAll() {
    return dao.findAll().stream()
        .map(AuthorFisrtAndSecondNameDto::new)
        .collect(Collectors.toList());
  }

  @Override
  public AuthorDaoImpl findById(Long id) {
    return null;
  }

  @Override
  public void update(AuthorFisrtAndSecondNameDto dto) {}

  @Override
  public void deleteById(Long id) {}
}
