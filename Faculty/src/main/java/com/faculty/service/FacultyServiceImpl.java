package com.faculty.service;


import com.faculty.entity.Administrator;
import com.faculty.entity.Faculty;
import com.faculty.repository.FacultyRepo;
import com.faculty.resource.AdministratorResource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {

    private FacultyRepo facultyRepo;
    private AdministratorResource administratorResource;

    public FacultyServiceImpl(FacultyRepo facultyRepo, AdministratorResource administratorResource) {
        this.facultyRepo = facultyRepo;
        this.administratorResource = administratorResource;
    }


    /**
     * method is used to save the entity to the database.
     *
     * @param faculty entity must not be {@literal null}.
     * @return the saved entity.
     */
    @Override
    public Faculty saveFaculty(Faculty faculty) {
        Administrator administrator = administratorResource.findAdministratorById(faculty.getAdministrator().getId());
        administrator.setFaculty(faculty);
        return facultyRepo.save(faculty);
    }

    /**
     *method is used to search for the entity.
     *
     * @param id must not be {@literal null}.
     * @return the entity with the given id or {@literal Optional#empty()} if none found.
     */
    @Override
    public Faculty findFacultyById(Long id) {
        return facultyRepo.findById(id).orElse(null);
    }

    /**
     * method is used to search for all entities.
     *
     * @return all entities.
     */
    @Override
    public List<Faculty> findFaculties() {
        return facultyRepo.findAll();
    }

    /**
     * method is used to remove the entity.
     *
     * @param id must not be {@literal null}.
     */
    @Override
    public void deleteFaculty(Long id) {
        Faculty faculty = facultyRepo.findById(id).orElse(null);
        if(faculty.getAdministrator()!=null) {
            Administrator administrator = administratorResource.findAdministratorById(faculty.getAdministrator().getId());
            administrator.setFaculty(null);
            administratorResource.saveAdministrator(administrator);
        }
        facultyRepo.deleteById(id);
    }

    /**
     * method is used to update the entity.
     *
     * @param faculty entity must not be {@literal null}.
     * @return the updated entity.
     */
    @Override
    public Faculty updateFaculty(Faculty faculty) {
        Faculty toUpdate = facultyRepo.findById(faculty.getId()).orElse(null);
        if(toUpdate!=null){
            toUpdate.setAdministrator(faculty.getAdministrator());
            toUpdate.setMinAvarage(faculty.getMinAvarage());
            toUpdate.setName(faculty.getName());
            toUpdate.setSize(faculty.getSize());
        }
        facultyRepo.save(toUpdate);
        return facultyRepo.findById(faculty.getId()).orElse(null);
    }
}
