package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}
