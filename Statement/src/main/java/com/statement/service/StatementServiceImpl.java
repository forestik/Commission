package com.statement.service;

import com.statement.entity.Abiturient;
import com.statement.entity.Faculty;
import com.statement.entity.Statement;
import com.statement.repository.StatementRepo;
import com.statement.resource.AbiturientResource;
import com.statement.resource.FacutlyResource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatementServiceImpl implements StatementService {

    private StatementRepo statementRepo;
    private FacutlyResource facutlyResource;
    private AbiturientResource abiturientResource;

    public StatementServiceImpl(StatementRepo statementRepo, FacutlyResource facutlyResource, AbiturientResource abiturientResource) {
        this.facutlyResource = facutlyResource;
        this.abiturientResource = abiturientResource;
        this.statementRepo = statementRepo;

    }

    /**
     * method is used to save the entity to the database.
     *
     * @param statement entity must not be {@literal null}.
     * @return the saved entity.
     */
    @Override
    public Statement saveStatement(Statement statement) {
        Abiturient abiturient = abiturientResource.findAbiturientById(statement.getAbiturient().getId());
        abiturient.setStatement(statement);
        return statementRepo.save(statement);
    }

    /**
     * method is used to process the entity.
     *
     * @param id must not be {@literal null}.
     * @return the processed entity.
     */
    @Override
    public Statement processingStatement(final Long id) {

        final Statement processstatement = statementRepo.findById(id).orElse(null);
        final Faculty processfaculty = facutlyResource.findFacultyById(processstatement.getFaculty().getId());
        final Abiturient processAbiturient = abiturientResource.findAbiturientById(processstatement.getAbiturient().getId());
        if (processstatement.getAverageMark() >= processfaculty.getMinAvarage()) {
            processstatement.setFaculty(facutlyResource.findFacultyById(processstatement.getFaculty().getId()));
            processAbiturient.setFaculty(facutlyResource.findFacultyById(processstatement.getFaculty().getId()));
            processstatement.setIsEntered(Boolean.TRUE);

        }
        abiturientResource.saveAbiturient(processAbiturient);
        return  statementRepo.save(processstatement);
    }

    /**
     * method is used to search for all entities.
     *
     * @return all entities.
     */
    @Override
    public List<Statement> findAllStatement() {
        return statementRepo.findAll();
    }

    /**
     * method is used to search for the entity.
     *
     * @param id must not be {@literal null}.
     * @return the entity with the given id or {@literal Optional#empty()} if none found.
     */
    @Override
    public Statement findStatementById(Long id) {
        return statementRepo.findById(id).orElse(null);
    }

    /**
     * method is used to remove the entity.
     *
     * @param id must not be {@literal null}.
     */
    @Override
    public void deleteStatement(Long id) {
        statementRepo.deleteById(id);
    }

}

