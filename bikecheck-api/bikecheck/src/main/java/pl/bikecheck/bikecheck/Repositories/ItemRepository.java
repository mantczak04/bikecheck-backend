package pl.bikecheck.bikecheck.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bikecheck.bikecheck.Entities.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
