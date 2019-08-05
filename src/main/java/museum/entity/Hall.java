package museum.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.util.ArrayList;
import java.util.List;

/**
 * Hall entity.
 *
 * @author Katerena Horokh
 * @version 1.0
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hall {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Positive
  private Long id;

  @Column(nullable = false, unique = true)
  @Length(min = 3, max = 20)
  private String name;

  @ManyToOne
  @JoinColumn(nullable = false)
  private Worker worker;

  @OneToMany(mappedBy = "hall")
  private List<Exhibit> exhibits = new ArrayList<>();
}
