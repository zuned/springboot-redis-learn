package com.learn.redis.redisdemo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
public class Programmer implements Serializable  {
    private long id;
    private String company;
    private String name;

}
