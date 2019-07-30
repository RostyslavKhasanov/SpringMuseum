package museum.service;

import museum.dto.author.AuthorSaveDtoRequest;
import museum.dto.author.AuthorUpdateDtoRequest;
import museum.dto.author.AuthorDtoResponse;
import museum.dto.author.AuthorIdFirstSecondNameDtoResponse;
import museum.entity.Author;

import java.util.List;

public interface AuthorService {

  void save(AuthorSaveDtoRequest dto);

  List<AuthorIdFirstSecondNameDtoResponse> findAll();

  AuthorDtoResponse findById(Long id);

  Author getOneById(Long id);

  void update(AuthorUpdateDtoRequest dto);

  void deleteById(Long id);
}
