package com.faculty.rest;

import com.faculty.entity.Faculty;
import com.faculty.service.FacultyService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/faculty")
public class FacultyController {

    private FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }
    @GetMapping(value = "/findbyid")
    public Faculty findFacultyById(@RequestParam(name = "id") final Long id){
        return facultyService.findFacultyById(id);
    }

    @GetMapping(value = "/findall")
    public List<Faculty> findFaculties(){
        return facultyService.findFaculties();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Faculty saveFaculty(@RequestBody final Faculty faculty){
        return facultyService.saveFaculty(faculty);
    }

    @PutMapping
    public  Faculty updateFaculty(@RequestBody final Faculty faculty){
        return facultyService.updateFaculty(faculty);
    }

    @DeleteMapping()
    public void deleteFaculty(@RequestParam(name = "id")final Long id){
        facultyService.deleteFaculty(id);
    }
}
