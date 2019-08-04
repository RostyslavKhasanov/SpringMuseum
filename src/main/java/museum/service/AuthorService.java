package museum.service;

import museum.dto.author.AuthorFullDto;
import museum.dto.author.AuthorIdInitialsDto;
import museum.dto.author.AuthorInitialsDto;
import museum.entity.Author;
import museum.exception.BadIdException;

import java.util.List;

public interface AuthorService {

  void save(AuthorInitialsDto dto);

  List<AuthorIdInitialsDto> findAll();

  AuthorFullDto findById(Long id) throws BadIdException;

  Author getOneById(Long id) throws BadIdException;

  void update(AuthorIdInitialsDto dto) throws BadIdException;

  void deleteById(Long id) throws BadIdException;
}
