package museum.dao;

import museum.entity.Author;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Repository
@Transactional
public class AuthorDao extends ElementDaoImpl<Author> {
  public AuthorDao() {
    super(Author.class);
  }
}
