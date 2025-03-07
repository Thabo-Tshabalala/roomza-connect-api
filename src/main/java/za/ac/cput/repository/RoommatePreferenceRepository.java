package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.model.RoommatePreference;

@Repository
public interface RoommatePreferenceRepository extends JpaRepository<RoommatePreference, Long> {
}
