package museum.service.impl;

import museum.dto.author.AuthorFirstAndSecondNameDto;
import museum.entity.Author;
import museum.exception.BadIdException;
import museum.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

  @Autowired private AuthorDao dao;

  @Transactional
  @Override
  public void save(AuthorFirstAndSecondNameDto dto) {
    Author author = authorFistAndSecondNameDtoToAuthor(dto);
    dao.save(author);
  }

  @Transactional
  @Override
  public List<AuthorFirstAndSecondNameDto> findAll() {
    return dao.findAll().stream()
        .map(AuthorFirstAndSecondNameDto::new)
        .collect(Collectors.toList());
  }

  @Transactional
  @Override
  public Author findById(Long id) {
    Author author = dao.findById(id);
    if (author == null) {
      throw new BadIdException("Author has not row with id " + id);
    }
    return author;
  }

  @Transactional
  @Override
  public Author update(AuthorFirstAndSecondNameDto dto) {
    Author author = authorFistAndSecondNameDtoToAuthor(dto);
    Author update = dao.update(author);
    if (author == null) {
      throw new BadIdException("Author has not row with id " + dto.getId());
    }
    return update;
  }

  @Transactional
  @Override
  public void deleteById(Long id) {
    Boolean isDeleted = dao.deleteById(id);
    if (!isDeleted) {
      throw new BadIdException("Author has not row with id " + id);
    }
  }

  private Author authorFistAndSecondNameDtoToAuthor(AuthorFirstAndSecondNameDto dto) {
    Author author = new Author();
    author.setId(dto.getId());
    author.setFirstName(dto.getFirstName());
    author.setSecondName(dto.getSecondName());
    return author;
  }
}
