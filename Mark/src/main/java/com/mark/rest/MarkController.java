package com.mark.rest;


import com.mark.entity.Mark;
import com.mark.service.MarkService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mark")
public class MarkController {
    private MarkService markService;

    public MarkController(MarkService markService) {
        this.markService = markService;
    }

    @GetMapping(value = "/findall")
    public List<Mark> findAllMarks() {
        return markService.findAllMarks();
    }

    @GetMapping(value = "/findbyid")
    public Mark findMarkById(@RequestParam(name = "id") Long id) {
        return markService.findMarkById(id);
    }

    @PostMapping(value = "/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Mark saveMark(@RequestBody final Mark mark) {
        return markService.createMark(mark);
    }

    @PutMapping(value = "/update")
    public Mark updateMark(@RequestBody final Mark mark) {
        return markService.updateMark(mark);
    }

    @DeleteMapping(value = "/delete")
    public void deleteMark(@RequestParam(name = "id")Long id){
        markService.deleteMark(id);
    }
}
