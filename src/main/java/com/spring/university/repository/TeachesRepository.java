
package com.spring.university.repository;

import com.spring.university.model.Teaches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeachesRepository extends JpaRepository<Teaches, Long> {
    List<Teaches> findBySectionId(Long sectionId);
}