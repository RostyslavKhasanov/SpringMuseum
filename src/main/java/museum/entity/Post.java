package museum.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

/**
 * Pojo class for 'post' database entity.
 *
 * @author Rostyslav Khasanov
 * @version 1.0
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Positive
  private Long id;

  @Column(nullable = false, unique = true)
  @Length(min = 2, max = 20)
  private String name;

  @OneToMany(mappedBy = "post")
  private List<Worker> workers = new ArrayList<>();
}
