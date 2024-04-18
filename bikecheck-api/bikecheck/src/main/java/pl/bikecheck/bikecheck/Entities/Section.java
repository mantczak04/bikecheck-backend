package pl.bikecheck.bikecheck.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL)
    private List<Item> items;

    @ManyToOne
    @JoinColumn(name = "athlete_id")
    @JsonIgnore
    private Athlete athlete;

}
