package museum.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Exhibit entity.
 *
 * @author Nazar Stasyuk
 * @version 1.0
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Exhibit {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true, length = 100)
  private String name;

  @Column(nullable = false, length = 50)
  private String material;

  @Column(nullable = false, length = 50)
  private String technology;

  @ManyToOne
  @JoinColumn(nullable = false)
  private Author author;

  @ManyToOne
  @JoinColumn(nullable = false)
  private Hall hall;
}
