package com.faculty.service;

import com.faculty.entity.Faculty;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FacultyService {

    Faculty saveFaculty(final Faculty faculty);

    Faculty findFacultyById(final Long id);

    List<Faculty> findFaculties();

    void deleteFaculty(final Long id);

    Faculty updateFaculty(final Faculty faculty);
}
