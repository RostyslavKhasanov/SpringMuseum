package museum.service.impl;

import museum.dao.AuthorDao;
import museum.dto.author.AuthorFullDto;
import museum.dto.author.AuthorIdInitialsDto;
import museum.dto.author.AuthorInitialsDto;
import museum.entity.Author;
import museum.exception.BadIdException;
import museum.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service for Author logic.
 *
 * @author Nazar Stasyuk
 * @version 1.0
 */
@Service
public class AuthorServiceImpl implements AuthorService {

  @Autowired private AuthorDao dao;

  /** Method that save new author. */
  @Transactional
  @Override
  public void save(AuthorInitialsDto dto) {
    Author author = new Author();
    author.setFirstName(dto.getFirstName());
    author.setSecondName(dto.getSecondName());
    dao.save(author);
  }

  /**
   * Method that return all authors dto.
   *
   * @return List of AuthorIdInitialsDto.
   */
  @Transactional
  @Override
  public List<AuthorIdInitialsDto> findAll() {
    return dao.findAll().stream().map(AuthorIdInitialsDto::new).collect(Collectors.toList());
  }

  /**
   * Method that return author dto by id.
   *
   * @return AuthorFullDto - this is dto of author.
   */
  @Transactional
  @Override
  public AuthorFullDto findById(Long id) throws BadIdException {
    Author author = dao.findById(id);
    if (author == null) {
      throw new BadIdException("Author has no row with id " + id);
    }
    return new AuthorFullDto(dao.findById(id));
  }

  /**
   * Method that return author by id.
   *
   * @return Author - this is entity.
   */
  @Override
  public Author getOneById(Long id) throws BadIdException {
    Author author = dao.findById(id);
    if (author == null) {
      throw new BadIdException("Author has no row with id " + id);
    }
    return author;
  }

  /** Method that update author. */
  @Transactional
  @Override
  public void update(AuthorIdInitialsDto dto) throws BadIdException {
    Author author = new Author();
    author.setId(dto.getId());
    author.setFirstName(dto.getFirstName());
    author.setSecondName(dto.getSecondName());
    Author newAuthor = dao.update(author);
    if (newAuthor == null) {
      throw new BadIdException("Author has no row with id " + dto.getId());
    }
  }

  /** Method that delete author by id. */
  @Transactional
  @Override
  public void deleteById(Long id) throws BadIdException {
    Boolean isDeleted = dao.deleteById(id);

    if (!isDeleted) {
      throw new BadIdException("Author has no row with id " + id);
    }
  }
}
