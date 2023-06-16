package com.revature.daos;

import com.revature.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDAO extends JpaRepository<Person, Integer> {

    Person findByUsername(String username);

    boolean existsByUsername(String username);
}
