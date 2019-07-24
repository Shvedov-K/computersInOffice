package com.netcracker.model;

import jdk.jfr.DataAmount;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.LinkedList;

@Data
public class Office {
    @Id
    public ObjectId id;

    public String name;
    public int countOfEmployee;
    public LinkedList<Computer> computerList;

}
