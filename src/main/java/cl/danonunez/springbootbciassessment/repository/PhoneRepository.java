package cl.danonunez.springbootbciassessment.repository;

import cl.danonunez.springbootbciassessment.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PhoneRepository extends JpaRepository<Phone, UUID> {
}
