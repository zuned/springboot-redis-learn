package com.learn.redis.redisdemo.service;

import com.learn.redis.redisdemo.model.Programmer;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ProgrammerService {
    void setProgrammerAsString(String idKey , String programmer);
    String getProgammerAsString(String idKey);

    // List Operations On redis
    void addToProgrammersList(Programmer programmer);
    List getProgrammersList();
    Long getProgrammersListCount();

    //Set Operations On Redis
    void addToProgrammersSet(Programmer programmer);
    Set getProgrammersSet();
    boolean isProgrammerExists(Programmer programmer);

    //Hash Operations On Redis
    void saveHash(Programmer programmer);
    void updateHash(Programmer programmer);
    Map<Long,Programmer> findAllHash();
    Programmer findInHash(Long id);
    void deleteHash(Long id);
}
