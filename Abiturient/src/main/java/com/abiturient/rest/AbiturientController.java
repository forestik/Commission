package com.abiturient.rest;


import com.abiturient.entity.Abiturient;
import com.abiturient.entity.Faculty;
import com.abiturient.service.AbiturientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/abiturient")
public class AbiturientController {

    private AbiturientService abiturientService;

    public AbiturientController(AbiturientService abiturientService) {
        this.abiturientService = abiturientService;
    }

    @GetMapping
    public List<Abiturient> getAbiturient() {
        return abiturientService.findAllAbiturient();
    }

    @GetMapping(value = "/findbyid")
    public Abiturient findAbiturientById(@RequestParam(name = "id") final Long id){
        return abiturientService.findAbiturientById(id);
    }

    @PostMapping(value = "/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Abiturient saveAbiturient(@RequestBody final Abiturient abiturient){
        return abiturientService.saveAbiturient(abiturient);
    }

    @GetMapping(value = "/faculties")
    public ResponseEntity<Faculty[]> getFaculties() {
        return abiturientService.findFaculties();
    }

    @GetMapping(value = "/findfacultybyid")
    public ResponseEntity<Faculty> getFacultyById(@RequestParam(name = "id") final Long id) {
        return abiturientService.findFacultyById(id);
    }

    @PutMapping(value = "/updateabiturient")
    public Abiturient updateAbiturient(@RequestBody final Abiturient abiturient){
        return abiturientService.updateAbiturient(abiturient);
    }

    @DeleteMapping(value = "/deleteabiturient")
    public void deleteAbiturient(@RequestParam(name = "id") final Long id){
        abiturientService.deleteAbiturient(id);
    }

}
