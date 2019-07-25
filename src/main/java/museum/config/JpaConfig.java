package museum.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Configuration
@EnableTransactionManagement
public class JpaConfig {
  @Bean
  public EntityManager entityManager() {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("primary");
    return entityManagerFactory.createEntityManager();
  }

  @Bean
  public JpaTransactionManager transactionManager() {
    return new JpaTransactionManager(entityManager().getEntityManagerFactory());
  }
}
