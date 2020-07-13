package com.statement.repository;


import com.statement.entity.Statement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatementRepo extends JpaRepository<Statement,Long> {
}
