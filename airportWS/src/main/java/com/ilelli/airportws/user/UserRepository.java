package com.ilelli.airportws.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
interface UserRepository extends JpaRepository<Users, UUID> {
    Optional<Users> findUserByLogin(String login);
}
