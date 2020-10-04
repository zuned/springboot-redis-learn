package com.learn.redis.redisdemo.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.redis.redisdemo.model.Programmer;
import com.learn.redis.redisdemo.service.ProgrammerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class ProgrammerController {

    @Autowired
    private ProgrammerService programmerService;


    @PostMapping("/programmer-string")
    public void addProgrammer(@RequestBody Programmer programmer) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        this.programmerService.setProgrammerAsString(String.valueOf(programmer.getId()),mapper.writeValueAsString(programmer));
    }

    @GetMapping("/programmer-string/{id}")
    @ResponseBody
    public  String getProgrammer(@PathVariable String id) {
        return this.programmerService.getProgammerAsString(id);
    }

    // List Operations On redis
    @PostMapping("/programmer-list")
    public  void addToProgrammersList(@RequestBody  Programmer programmer) {
        this.programmerService.addToProgrammersList(programmer);
    }

    @GetMapping("/programmer-list")
    public @ResponseBody List<Programmer> getProgrammersList() {
        return this.programmerService.getProgrammersList();
    }

    @GetMapping("/programmer-list-count")
    public Long getProgrammersListCount() {
        return this.programmerService.getProgrammersListCount();
    }

    // Redis Set Key
    //Set Operations On Redis
    @PostMapping("/programmer-set")
    public void addToProgrammersSet(@RequestBody  Programmer programmer) {
        this.programmerService.addToProgrammersSet(programmer);
    }
    @GetMapping("/programmer-set")
    public @ResponseBody Set getProgrammersSet() {
        return this.programmerService.getProgrammersSet();
    }
    @PostMapping("/programmer-set/exists")
    public boolean isProgrammerExists(@RequestBody  Programmer programmer) {
        return  this.programmerService.isProgrammerExists(programmer);
    }

    //Hash Operations On Redis
    @PostMapping("/programmer-hash")
    public void saveHash(@RequestBody Programmer programmer) {
        this.programmerService.saveHash(programmer);
    }
    @PutMapping("/programmer-hash")
    public void updateHash(@RequestBody Programmer programmer) {
        this.programmerService.updateHash(programmer);
    }
    @GetMapping("/programmer-hash")
    public @ResponseBody Map<Long,Programmer> findAllHash() {
        return this.programmerService.findAllHash();
    }
    @GetMapping("/programmer-hash/{id}")
    public @ResponseBody Programmer findInHash(@PathVariable Long id) {
        Programmer programmer =  this.programmerService.findInHash(id);
        return programmer;
    }
    @DeleteMapping("/programmer-hash/{id}")
    public void deleteHash(@PathVariable Long id) {
        this.programmerService.deleteHash(id);
    }

}
