package museum.entity;

import lombok.*;

import javax.persistence.*;

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

  @Column(nullable = false, unique = true)
  private String name;

  @Column(nullable = false)
  private String material;

  @Column(nullable = false)
  private String technology;

  @ManyToOne
  private Author author;

  @ManyToOne
  private Hall hall;
}
