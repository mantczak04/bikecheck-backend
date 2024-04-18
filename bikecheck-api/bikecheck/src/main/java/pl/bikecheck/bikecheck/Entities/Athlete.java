package pl.bikecheck.bikecheck.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import pl.bikecheck.bikecheck.Utils.Country;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "athletes")
public class Athlete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "biography")
    private String biography;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "country")
    private Country country;

    @Column(name = "imageUrl", length = 1024, columnDefinition = "TEXT")
    private String imageUrl;

    @OneToMany(mappedBy = "athlete", cascade = CascadeType.ALL)
    private List<Section> sections;
}
