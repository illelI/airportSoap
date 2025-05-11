package com.ilelli.airportws.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<Users, UUID> {
    Optional<Users> findFirstByLogin(String login);
    Users findFirstById(UUID id);
    Users findFirstByNameAndSurname(String name, String surname);
}
