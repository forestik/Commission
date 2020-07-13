package com.abiturient.service;


import com.abiturient.entity.Abiturient;
import com.abiturient.entity.Faculty;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AbiturientService {

    Abiturient saveAbiturient(final Abiturient abiturient);

    List<Abiturient> findAllAbiturient();

    Abiturient findAbiturientById(final Long id);

    ResponseEntity<Faculty[]> findFaculties();

    ResponseEntity<Faculty> findFacultyById(final Long id);

    void deleteAbiturient(final Long id);

    Abiturient updateAbiturient(final Abiturient abiturient);
}
