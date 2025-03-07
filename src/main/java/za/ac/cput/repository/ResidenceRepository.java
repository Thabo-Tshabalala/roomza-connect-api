package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.model.Residence;

@Repository
public interface ResidenceRepository extends JpaRepository<Residence, Long> {
}
