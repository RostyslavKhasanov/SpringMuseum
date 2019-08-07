package museum.service.impl;

import lombok.AllArgsConstructor;
import museum.dao.AuthorDao;
import museum.dto.author.AuthorFullDto;
import museum.dto.author.AuthorIdInitialsDto;
import museum.dto.author.AuthorInitialsDto;
import museum.entity.Author;
import museum.exception.BadIdException;
import museum.exception.EntityConstraintException;
import museum.service.AuthorService;
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
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

  private AuthorDao dao;

  /** Method that save new author. */
  @Transactional
  @Override
  public void save(AuthorInitialsDto dto) {
    dao.save(
        Author.builder().firstName(dto.getFirstName()).secondName(dto.getSecondName()).build());
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
    return new AuthorFullDto(author);
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
    Author author =
        Author.builder()
            .id(dto.getId())
            .firstName(dto.getFirstName())
            .secondName(dto.getSecondName())
            .build();

    Author newAuthor = dao.update(author);
    if (newAuthor == null) {
      throw new BadIdException("Author has no row with id " + dto.getId());
    }
  }

  /** Method that delete author by id. */
  @Transactional
  @Override
  public void deleteById(Long id) throws BadIdException {
    Author author = getOneById(id);
    if (author.getExhibits().size() != 0) {
      throw new EntityConstraintException("You can not delete this author because he is using.");
    }
    dao.deleteById(id);
  }
}
