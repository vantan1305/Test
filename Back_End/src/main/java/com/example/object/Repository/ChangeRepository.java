package com.example.object.Repository;

import com.example.object.Entity.Change;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChangeRepository extends JpaRepository<Change,Long> {
}
