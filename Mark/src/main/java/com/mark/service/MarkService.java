package com.mark.service;


import com.mark.entity.Mark;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MarkService {
    Mark createMark(final Mark mark);

    List<Mark> findAllMarks();

    Mark findMarkById(final Long id);

    Mark updateMark(final Mark mark);

    void deleteMark(final Long id);
}
