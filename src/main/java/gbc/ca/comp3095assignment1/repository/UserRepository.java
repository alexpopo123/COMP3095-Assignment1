package gbc.ca.comp3095assignment1.repository;

import gbc.ca.comp3095assignment1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
