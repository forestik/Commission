package com.mark.repository;


import com.mark.entity.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkRepo extends JpaRepository<Mark,Long> {
}
