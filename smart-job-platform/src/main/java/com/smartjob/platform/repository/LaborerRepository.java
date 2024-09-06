// LaborerRepository.java
import java.util.List;
package com.smartjob.platform.repository;

import com.smartjob.platform.model.Laborer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LaborerRepository extends JpaRepository<Laborer, Long> {
    List<Laborer> findBySkillsContainingAndAvailabilityContaining(String skills, String availability);
}
