package museum.dao.impl;

import museum.dao.AuthorDao;
import museum.dao.ElementDaoImpl;
import museum.entity.Author;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorDaoImpl extends ElementDaoImpl<Author> implements AuthorDao {
  public AuthorDaoImpl() {
    super(Author.class);
  }
}
