package museum.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;

/**
 * Excursion entity.
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
public class Excursion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Positive
  private Long id;

  @Column(nullable = false)
  @Length(min = 6, max = 30)
  private String description;

  @Column(nullable = false)
  private LocalDateTime begin;

  @Column(nullable = false)
  private LocalDateTime end;

  @Column(nullable = false)
  private Double price;

  @ManyToOne
  @JoinColumn(nullable = false)
  private Worker worker;
}
