package com.netcracker.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.LinkedList;

@Data
public class Office {
    @Id
    private ObjectId id;

    private String name;
    private int countOfEmployee;
    private LinkedList<Computer> computerList;
}
