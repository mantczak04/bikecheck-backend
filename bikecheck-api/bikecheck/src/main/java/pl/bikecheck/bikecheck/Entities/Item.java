package pl.bikecheck.bikecheck.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "part")
    private String part;

    @Column(name = "name")
    private String name;

    @Column(name = "imageUrl", length = 1024, columnDefinition = "TEXT")
    private String imageUrl;

    @Column(name = "amazonUrl")
    private String amazonUrl;

    @ManyToOne
    @JoinColumn(name = "section_id")
    @JsonIgnore
    private Section section;
}
