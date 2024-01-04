package com.example.caso.repositories;

import com.example.caso.entities.OS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OsRepository extends JpaRepository<OS,Integer> {

}
