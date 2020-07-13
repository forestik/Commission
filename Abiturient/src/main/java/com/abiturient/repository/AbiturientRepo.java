package com.abiturient.repository;


import com.abiturient.entity.Abiturient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbiturientRepo extends JpaRepository<Abiturient, Long> {
}
