package cl.danonunez.springbootbciassessment.repository;

import cl.danonunez.springbootbciassessment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    boolean existsByEmail(String email);
}
