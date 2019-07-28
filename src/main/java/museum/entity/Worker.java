package museum.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Worker {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String firstName;

  @Column(nullable = false)
  private String secondName;

  @ManyToOne private Post post;

  @OneToMany(mappedBy = "worker", fetch = FetchType.EAGER)
  private List<Hall> halls = new ArrayList<>();

  @OneToMany(mappedBy = "worker", fetch = FetchType.EAGER)
  private List<Excursion> excursions = new ArrayList<>();
}
