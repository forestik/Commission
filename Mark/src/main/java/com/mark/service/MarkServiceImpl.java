package com.mark.service;

import com.mark.entity.Mark;
import com.mark.repository.MarkRepo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class MarkServiceImpl implements MarkService {
    private MarkRepo markRepo;

    public MarkServiceImpl(MarkRepo markRepo) {
        this.markRepo = markRepo;
    }

    /**
     * method is used to save the entity to the database.
     *
     * @param mark entity must not be {@literal null}.
     * @return the saved entity.
     */
    @Override
    public Mark createMark(Mark mark) {
        return markRepo.save(mark);
    }

    /**
     * method is used to search for all entities.
     *
     * @return all entities.
     */
    @Override
    public List<Mark> findAllMarks() {
        return markRepo.findAll();
    }

    /**
     * method is used to search for the entity.
     *
     * @param id must not be {@literal null}.
     * @return the entity with the given id or {@literal Optional#empty()} if none found.
     */
    @Override
    public Mark findMarkById(Long id) {
        return markRepo.findById(id).orElse(null);
    }

    /**
     * method is used to update the entity.
     *
     * @param mark entity must not be {@literal null}.
     * @return the updated entity.
     */
    @Override
    public Mark updateMark(Mark mark) {
        final Mark toUpdate = markRepo.findById(mark.getId()).orElse(null);
        if (toUpdate != null) {
            toUpdate.setName(mark.getName());
            toUpdate.setMark(mark.getMark());
            toUpdate.setStatement((mark.getStatement()));
            toUpdate.setAbiturient(mark.getAbiturient());
        }
        return markRepo.save(toUpdate);
    }

    /**
     * method is used to remove the entity.
     *
     * @param id must not be {@literal null}.
     */
    @Override
    public void deleteMark(Long id) {
        markRepo.deleteById(id);
    }
}
