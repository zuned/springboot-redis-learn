package com.learn.redis.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Employee implements Serializable {
    Long id;
    String name;
}
