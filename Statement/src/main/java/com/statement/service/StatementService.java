package com.statement.service;


import com.statement.entity.Statement;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StatementService {

    Statement saveStatement(final Statement statement);

    Statement processingStatement(final Long id);

    List<Statement> findAllStatement();

    Statement findStatementById(final Long id);

    void deleteStatement(final Long id);

}
