package com.learn.redis.redisdemo.service;

import com.learn.redis.redisdemo.dao.ProgrammerRepository;
import com.learn.redis.redisdemo.model.Programmer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ProgrammerServiceImpl implements ProgrammerService {

    @Autowired
    private ProgrammerRepository programmerRepository;

    @Override
    public void setProgrammerAsString(String idKey, String programmer) {
        this.programmerRepository.setProgrammerAsString(idKey,programmer);
    }

    @Override
    public String getProgammerAsString(String idKey) {
        return this.programmerRepository.getProgammerAsString(idKey);
    }

    /******** List Operations *****/
    @Override
    public void addToProgrammersList(Programmer programmer) {
        this.programmerRepository.addToProgrammersList(programmer);
    }

    @Override
    public List getProgrammersList() {
        return this.programmerRepository.getProgrammersList();
    }

    @Override
    public Long getProgrammersListCount() {
        return this.programmerRepository.getProgrammersListCount();
    }
    /** Set ****/
    @Override
    public void addToProgrammersSet(Programmer programmer) {
        this.programmerRepository.addToProgrammersSet(programmer);
    }

    @Override
    public Set getProgrammersSet() {
        return this.programmerRepository.getProgrammersSet();
    }

    @Override
    public boolean isProgrammerExists(Programmer programmer) {
        return this.programmerRepository.isProgrammerExists(programmer);
    }

    @Override
    public void saveHash(Programmer programmer) {
        this.programmerRepository.saveHash(programmer);
    }

    @Override
    public void updateHash(Programmer programmer) {
        this.programmerRepository.updateHash(programmer);
    }

    @Override
    public Map<Long, Programmer> findAllHash() {
        return this.programmerRepository.findAllHash();
    }

    @Override
    public Programmer findInHash(Long id) {
        return this.programmerRepository.findInHash(id);
    }

    @Override
    public void deleteHash(Long id) {
        this.programmerRepository.deleteHash(id);
    }


}
