package museum.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Pojo class for 'worker' database entity.
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
public class Worker {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  @Length(min = 1, max = 20)
  private String firstName;

  @Length(min = 1, max = 20)
  @Column(nullable = false)
  private String secondName;

  @ManyToOne private Post post;

  @OneToMany(mappedBy = "worker")
  private List<Hall> halls = new ArrayList<>();

  @OneToMany(mappedBy = "worker")
  private List<Excursion> excursions = new ArrayList<>();
}
