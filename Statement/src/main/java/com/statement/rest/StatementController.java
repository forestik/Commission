package com.statement.rest;


import com.statement.entity.Statement;
import com.statement.service.StatementService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/statement")
public class StatementController {

    private StatementService statementService;

    public StatementController(StatementService statementService) {
        this.statementService = statementService;
    }

    @PostMapping(value = "/savestatement")
    @ResponseStatus(HttpStatus.CREATED)
    public Statement saveStatement(@RequestBody final Statement statement){
        return statementService.saveStatement(statement);
    }

    @GetMapping(value = "/findstatements")
    public List<Statement> findStatements() {
        return statementService.findAllStatement();
    }

    @GetMapping(value = "/findstatementbyid")
    public Statement findStatementById(final Long id) {
        return statementService.findStatementById(id);
    }

    @PutMapping(value = "/process")
    public Statement processStatement(@RequestParam(name = "id") final Long id) {
        return statementService.processingStatement(id);
    }

    @DeleteMapping(value = "/deletestatement")
    public void deleteStatement(@RequestParam(name = "id") final Long id){
        statementService.deleteStatement(id);
    }


}
