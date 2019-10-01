package com.netcracker.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.LinkedList;
import java.util.List;

@Data
public class Office {
    @Id
    private ObjectId id;

    private String name;
    private int countOfEmployee;
    private List<Computer> computerList = new LinkedList<>();

    public String getId() {
        return id.toHexString();
    }

    public ObjectId copyId() {
        return id;
    }
}
