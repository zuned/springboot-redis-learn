package com.learn.redis.redisdemo.dao;

import com.learn.redis.redisdemo.model.Programmer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Repository
public class ProgrammerRepositoryImpl implements  ProgrammerRepository {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;


    @Override
    public void setProgrammerAsString(String idKey, String programmer) {
        this.redisTemplate.opsForValue().set(idKey , programmer);
        this.redisTemplate.expire(idKey , 10 , TimeUnit.SECONDS);
    }

    @Override
    public String getProgammerAsString(String idKey) {
        return (String)this.redisTemplate.opsForValue().get(idKey);
    }

    /****************List Operations *********/
    private  static final String REDIS_LIST_KEY ="ProgrammerList";
    @Autowired
    ListOperations<String,Programmer> listOperations;

    @Override
    public void addToProgrammersList(Programmer programmer) {
        //this.redisTemplate.opsForList().leftPush(REDIS_LIST_KEY , programmer);
        this.listOperations.leftPush(REDIS_LIST_KEY , programmer);
    }
    @Override
    public List getProgrammersList() {
        return this.listOperations.range(REDIS_LIST_KEY , 0, -1);
    }
    @Override
    public Long getProgrammersListCount() {
        return this.listOperations.size(REDIS_LIST_KEY);
    }

    /************** Set Operations ***************/
    private static final String REDIS_SET_KEY = "ProgrammerSet";
    @Autowired
    private SetOperations<String,Programmer> setOperations;

    @Override
    public void addToProgrammersSet(Programmer programmer) {
        this.setOperations.add(REDIS_SET_KEY , programmer);
    }
    @Override
    public Set getProgrammersSet() {
        return this.setOperations.members(REDIS_SET_KEY);
    }
    @Override
    public boolean isProgrammerExists(Programmer programmer) {
        return this.setOperations.isMember(REDIS_SET_KEY , programmer);
    }

    /********** Hash Operations on Redis ***************/
    private static final String REDIS_HASH_KEY = "ProgrammerHash";
    @Autowired
    private HashOperations<String,Long,Programmer> hashOperations;

    @Override
    public void saveHash(Programmer programmer) {
        this.hashOperations.put(REDIS_HASH_KEY ,programmer.getId() , programmer);
    }

    @Override
    public void updateHash(Programmer programmer) {
        this.hashOperations.put(REDIS_HASH_KEY ,programmer.getId() , programmer);
    }

    @Override
    public Map<Long, Programmer> findAllHash() {
        return this.hashOperations.entries(REDIS_HASH_KEY);
    }

    @Override
    public Programmer findInHash(Long id) {
        return this.hashOperations.get(REDIS_HASH_KEY,id);
    }

    @Override
    public void deleteHash(Long id) {
        this.hashOperations.delete(REDIS_HASH_KEY ,id);
    }


}
