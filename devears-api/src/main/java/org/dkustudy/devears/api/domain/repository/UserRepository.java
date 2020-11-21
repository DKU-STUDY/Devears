package org.dkustudy.devears.api.domain.repository;

import org.dkustudy.devears.api.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByGithubId(String id);
}
