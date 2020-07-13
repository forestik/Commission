package com.abiturient.service;


import com.abiturient.entity.Abiturient;
import com.abiturient.entity.Faculty;
import com.abiturient.repository.AbiturientRepo;
import com.abiturient.resource.FacutlyResource;
import com.abiturient.resource.StatementResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbiturientServiceImpl implements AbiturientService {

    private AbiturientRepo abiturientRepo;
    private StatementResource statementResource;
    private FacutlyResource facutlyResource;

    public AbiturientServiceImpl(AbiturientRepo abiturientRepo, StatementResource statementResource, FacutlyResource facutlyResource) {
        this.abiturientRepo = abiturientRepo;
        this.statementResource = statementResource;
        this.facutlyResource = facutlyResource;
    }

    /**
     * method is used to save the entity to the database.
     *
     * @param abiturient entity must not be {@literal null}.
     * @return the saved entity.
     */
    @Override
    public Abiturient saveAbiturient(final Abiturient abiturient) {
        return abiturientRepo.save(abiturient);
    }


    /**
     * method is used to search for all entities.
     *
     * @return all entities.
     */
    @Override
    public List<Abiturient> findAllAbiturient() {
        return abiturientRepo.findAll();
    }

    /**
     * method is used to search for the entity.
     *
     * @param id must not be {@literal null}.
     * @return the entity with the given id or {@literal Optional#empty()} if none found.
     */
    @Override
    public Abiturient findAbiturientById(final Long id) {
        return abiturientRepo.findById(id).orElse(null);
    }

    /**
     * method is used to search for all entities.
     *
     * @return all entities.
     */
    @Override
    public ResponseEntity<Faculty[]> findFaculties() {
        return facutlyResource.findFaculty();
    }

    /**
     * method is used to search for the entity.
     *
     * @param id must not be {@literal null}.
     * @return the entity with the given id or {@literal Optional#empty()} if none found.
     */
    @Override
    public ResponseEntity<Faculty> findFacultyById(Long id) {
        return facutlyResource.findFacultyById(id);
    }

    /**
     * method is used to remove the entity.
     *
     * @param id must not be {@literal null}.
     */
    @Override
    public void deleteAbiturient(Long id) {
        Abiturient abiturient = (abiturientRepo.findById(id).orElse(null));
        if(abiturient.getStatement()!=null && abiturient.getStatement().getId()!=null)
            statementResource.deleteStatementById(abiturient.getStatement().getId());
        abiturientRepo.deleteById(id);
    }

    /**
     * method is used to update the entity.
     *
     * @param abiturient entity must not be {@literal null}.
     * @return the updated entity.
     */
    @Override
    public Abiturient updateAbiturient(Abiturient abiturient) {
        Abiturient toUpdate = abiturientRepo.findById(abiturient.getId()).orElse(null);
        toUpdate.setMarks(abiturient.getMarks());
        toUpdate.setStatement(abiturient.getStatement());
        toUpdate.setLastName(abiturient.getLastName());
        return abiturientRepo.save(toUpdate);
    }
}
