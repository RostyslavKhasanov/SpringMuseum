package MuseumSpring.entity;

import com.sun.org.glassfish.gmbal.ManagedAttribute;
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
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne
    private Worker worker;

    @OneToMany(mappedBy = "hall")
    private List<Exhibit> exhibits = new ArrayList<>();

}
