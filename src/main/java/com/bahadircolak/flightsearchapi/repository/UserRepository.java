package com.bahadircolak.flightsearchapi.repository;

import com.bahadircolak.flightsearchapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}

